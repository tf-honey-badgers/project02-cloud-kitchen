$(document).ready(function() {
	let bizIdx = $('#bizIdx').val()
	console.log(bizIdx);
	
	let menuId = new Array();
	let menuIdList = new Object();
	
	if($('#bizIdx').val() == "" || $('#bizIdx').val() == null){
		$('#mahout').hide();
		
	}else{
		
		// mahout item기반으로 menuId를 뽑아냄
		$.ajax({
			type : 'GET',
			url : '/customer/member/recommendation/menu/'+ bizIdx + '.json',
			success : function(data) {
				for(let i of data){
					menuId.push(i.itemID);
				}
				menuIdList.menuId = menuId;
				console.log(menuIdList);
				// 받아온 메뉴Id 기준으로 음식정보를 가져옴
				$.ajax({
					type : 'GET',
					url : '/customer/member/recommendation/info/'+menuId+'.json',
					success : function(dt) {
						
						for(let i=0;i<dt.length;i++){
							$('.container').eq(1).append(
									'<a href="" class="strip_list">'
									+'<div class="ribbon_1">Popular</div>'
									+'<div class="desc">'
									+'<div class="thumb_strip"><img src="https://s3.ap-northeast-2.amazonaws.com/honeybadgersfile/MenuPhoto/'+dt[i].mcode+'.png" alt=""></div>'
									+'<div class="rating">'
									+'<i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>'
									+'</div>'
									+'<h3>'+dt[i].mname+'</h3>'
									+'<div class="type">가격 : '+dt[i].mbasicPrice+'</div>'
									+'<div class="location">'
									+'주소를 적으세요'
									+'<span class="opening">오픈 11:00</span>'
									+'</div>'
									+'<ul><li>배달<i class="icon_check_alt2 ok"></i></li></ul>'
									+'</div><!-- End desc-->'
									+'</a><!-- End strip_list-->'
							);
						} // for문 끝
						
					},
					error : function(dt) {
						console.log(dt);
					}
				}); 
				
				
			},
			error : function(data) {
				console.log(data);
			}
		});
	}
});