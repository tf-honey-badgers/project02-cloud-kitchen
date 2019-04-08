/* Search =============================================== */
$(document).ready(function() {
	let source = [];
    $.ajax({
    	type : 'GET'
        , url : '/customer/kitchen/lists.json'
        , contentType : 'application/json'
        , success : function(data) {
        	let readList, category;
            for(let i = 0; i < 3; i++) {
            	if(i == 0) {
            		readList = data.kitchenList;
                    category = "지점";
                    for(let j = 0; j < readList.length; j++) {
                    	let readLine = readList[j];
                        source.push({label: readLine.kitchenname, category: category});				 		
                    }
            	}
                if(i == 1) {
                	readList = data.bizList;
                    category = "가게";
                    for(let j = 0; j < readList.length; j++) {
                    	let readLine = readList[j];
                        source.push({label: readLine.bizName, category: category});				 		
                    }
                }
                if(i == 2) {
                	readList = data.menuList;
                    category = "메뉴";
                    for(let j = 0; j < readList.length; j++) {
                    	let readLine = readList[j];
                        source.push({label: readLine.mname, category: category});				 		
                    }
                }
            }
        }
    	, error : function(data) {
    		console.log('ERRoR oCCURRED');
            console.log(data);
    	}
    });

    $.widget( "custom.catcomplete", $.ui.autocomplete, {
    	_create: function() {
    		this._super();
            this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
    	},
        _renderMenu: function( ul, items ) {
        	var that = this, currentCategory = " ";
            $.each( items, function( index, item ) {
            	var li;
                if ( item.category != currentCategory ) {
                	ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
                    currentCategory = item.category;
                }
                li = that._renderItemData( ul, item );
                if ( item.category ) {
                	li.attr( "aria-label", item.category + " : " + item.label );
                }
            });
        }
    });

    $(".search-query").catcomplete({
    	delay : 0
        , source : source
    });
});
/* End Search =============================================== */