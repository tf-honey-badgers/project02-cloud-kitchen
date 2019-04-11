package org.badgers.customer.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CartDetailVO;
import org.badgers.customer.model.CartVOExtend;
import org.badgers.customer.model.OrderDetailVOExtend;
import org.badgers.customer.model.OrderOptionVO;
import org.badgers.customer.model.OrderVOExtend;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class PaymentInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		return super.preHandle(request, response, handler);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		String custId = (String)session.getAttribute("uid");
		//address, phone이 바인딩 되어 넘어온 OrderVOExtend를 받는다
		OrderVOExtend order = (OrderVOExtend)modelAndView.getModel().get("order");
		
		// OrderVOExtend의 멤버인 OrderDetailVOExtend[]에 set해줄 List를 생성한다
		List<OrderDetailVOExtend> orderDetailList = new ArrayList<>();
		
		//세션에 저장해둔 cart를 받아온다
		List<CartVOExtend> cartList = (List) session.getAttribute("cart");
		
		//kitchenName은 OrderVoExtendVO에 하나만 필요하므로 cartList의 0번째 요소만 받아서 set해준다
		order.setKitchenName(cartList.get(0).getKitchenName());
		
		//주문(OrderExtendVO) 건에 매칭되는 orderId를 생성한다(custId + 시간)
		String orderId = custId+"_"+System.currentTimeMillis();
		
		order.setId(orderId);
		order.setCustId(custId);

		//모든 메뉴의 가격(+옵션가격 포함)을 합해줄 변수 선언
		int payAmt = 0;
		
		//OrderExtendVO의 멤버인 OrderDetailVOExtend[]의 setting을 위한 for문
		for(CartVOExtend cart:cartList) {
			//메뉴 총액 모두 더해서 결제 금액 계산
			payAmt += cart.getTotalAmt();
			
			//주문(OrderExtendVO)에 속한 메뉴들(OrderDetailVOExtend)을 생성하여 cart요소를 이용해 값을 넣어준다
			OrderDetailVOExtend orderDetail = new OrderDetailVOExtend();
			
			//메뉴들(OrderDetailVOExtend)에 매칭되는 orderDetailId를 생성한다 (orderId + cartList.index)
			String orderDetailId=orderId+cartList.indexOf(cart);
			
			orderDetail.setId(orderDetailId);
			orderDetail.setMenuId(cart.getMenuId()+"");
			orderDetail.setMenuName(cart.getMenuName());
			orderDetail.setMenuPrice(cart.getUnitPrice());
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setBizId(cart.getBizId());
			orderDetail.setBizName(cart.getBizName());
			orderDetail.setOrderId(orderId);
			
			//OrderOptionVO[]의 setting 준비
			//모든 옵션의 가격을 합해줄 변수 선언
			int optionPrice = 0;
			
			//OrderOptionVO[] set을 위한 List 생성
			List<OrderOptionVO> optionVOList = new ArrayList<>();
			
			//만약 option이 없는 메뉴라면
			if(cart.getOptions()==null) {
				//option 가격이 없으므로 메뉴의 가격만 TotalAmt에 set해준다
				orderDetail.setTotalAmt(orderDetail.getMenuPrice()*orderDetail.getQuantity());
				//orderDetailVO에 set 해줄 orderOption이 없으므로 그대로 List에 넣어준다 
				orderDetailList.add(orderDetail);
				
				continue;
			}
			
			//OrderDetailVOExtend의 멤버인 OrderOptionVO[]의 setting을 위한 for문
			for(CartDetailVO cartDetail:cart.getOptions()) {
				//옵션 총액 더함
				optionPrice += cartDetail.getMenuOptPrice();
				//메뉴(OrderDetailVOExtend)에 속한 옵션들(OrderDetailVOExtend)을 생성하여 cartDetailVO요소를 이용해 값을 넣어준다
				OrderOptionVO orderOptionVO = new OrderOptionVO();
				
				orderOptionVO.setOptId(cartDetail.getMenuOptId()+"");
				orderOptionVO.setOptName(cartDetail.getMenuOptName());
				orderOptionVO.setOptPrice(cartDetail.getMenuOptPrice()*orderDetail.getQuantity());
				orderOptionVO.setOrderDetailId(orderDetailId);
				
				//생성된 orderOptionVO를 List에 담아준다
				optionVOList.add(orderOptionVO);
			}
			
			orderDetail.setAddOptionPrice(optionPrice);
			
			//List를 Array로 바꿔서 set 해준다
			orderDetail.setOrderOptions(optionVOList.toArray(new OrderOptionVO[optionVOList.size()]));
			
			//메뉴의 가격 + 메뉴에 속한 옵션들의 가격
			orderDetail.setTotalAmt(orderDetail.getAddOptionPrice()+orderDetail.getMenuPrice());
			
			//생성된 orderDetail를 List에 담아준다
			orderDetailList.add(orderDetail);
			
		}
		
		//모든 메뉴들의 총액
		order.setPayAmt(payAmt);
		
		//List를 Array로 바꿔서 set 해준다
		order.setOrderDetails(orderDetailList.toArray(new OrderDetailVOExtend[orderDetailList.size()]));
		
		log.info(":::::::::::::::::::OrderVO:::::::::::::::::::::");
		log.info(order);
		log.info(":::::::::::::::::::OrderVO:::::::::::::::::::::");
		
		
		//OrderVOExtend의 멤버들 초기화 완료(PaymentVO 제외), "order"로 session에 저장
		session.setAttribute("order", order);
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
