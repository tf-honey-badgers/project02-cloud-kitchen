<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			<div class="col-md-3" id="sidebar">
				<div class="theiaStickySidebar">
					<div id="cart_box">
						<h3>
							Your order <i class="icon_cart_alt pull-right"></i>
						</h3>
						<table class="table table_summary">
							<thead>
							</thead>
							<tbody class="cartTable">
							<!-- bizName이 다를 때 가게 이름을 출력하기 위한 반복문 -->
								<!-- 카트 메뉴를 출력하기 위한 반복문  -->
								<c:forEach var="cart" items="${cart}">
									<tr class="bizNameRow">
										<td colspan="3"><strong>${cart.bizName}</strong></td>
									</tr>
									<tr>
										<td style="width: 10%;"><!-- <input class="check-order" type="checkbox"> --></td>
										<td class="menuData" data-cart-id="${cart.id}"><strong>${cart.quantity}x</strong> ${cart.menuName}<span class="pull-right">${cart.unitPrice}원</span></td>
									</tr>
									<!-- 옵션을 출력하기 위한 반복문 -->
									<c:forEach var="options" items="${cart.options}">									
										<tr>
											<td style="width: 10%;"></td>
											<td style="font-size: 11px;">${options.menuOptName} <span class="pull-right">+ ${options.menuOptPrice}원</span></td>
											<td style="width: 10%;"></td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="2" class="priceData" data-total-price="${cart.totalAmt}"><strong class="pull-right">합계&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.totalAmt}원</strong></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
						<table class="table table_summary">
							<tbody>
								<tr>
									<td class="total">총 금액 <span class="pull-right"></span>
									</td>
								</tr>
							</tbody>
						</table>
						<hr>
								<input type="submit" class="btn_full" id="orderNow" value="Order now">
					</div> <!-- End cart_box -->
				</div> <!-- End theiaStickySidebar -->
			</div> <!-- End col-md-4 -->
			
<script src="/customer/resources/js/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	var cartTotal = 0;
	for(var i = 0; i < $('.priceData').size(); i++) {
		var price = $('.priceData').eq(i).attr('data-total-price');
		cartTotal += parseInt(price);
	}
	$('.total span').text(cartTotal + '원');
	removeDuplicateBizNames();
})
	function removeDuplicateBizNames() {
		var bizNames = $('.bizNameRow');
		for(var i = 1; i < bizNames.size(); i++) {
			if(bizNames.eq(i).text() == bizNames.eq(i-1).text()) {
				bizNames.eq(i).remove();
			}
		}
	}
</script>
			