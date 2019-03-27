$(document).ready(function() {

	$('.confirm-order').on('click', function() {
		alert('sfdfsfds')
		$.ajax({
			url : 'payment/kakaopay',
		})
		

	})
});

