console.log("Member module..........")

var memberService = (function(){
//json 받아오기 
	function getList(callback, error){
		
		$.getJSON( list, function(data){
			if(callback){
				callback(data);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}


//종료
	return {
		getList : getList
		
	};
	
})();