function guid()
	{
		function s4()
			{
				return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1);
			}
		return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
	}

$(function()
	{
		$("#sortable").sortable({
			revert : true
		});
		$("#draggable li").draggable({
			appendTo : "body",
			helper : "clone"
		});
		$("droppable").droppable({
			accept : "#draggable li",
			activeClass : "ui-state-hover",
			hoverClass : "ui-state-active",
			drop : function(event, ui)
				{
					$(this).find(".placeholder").remove();
					var type = ui.draggable.text();
					var container = null;
					switch (type) {
					case "Text":
						{
							alert("Hi");
							$("<label for=\"" + type + "\">" + type + "    : " + "</label>").appendTo(this);
							container = $("<input id=" + guid() + " type=\"text\"> </input><br><br><br>");
							break;
						}
					case "Numeric":
						{
							$("<label for=\"" + type + "\">" + type + "    : " + "</label>").appendTo(this);
							container = $("<input id=" + guid() + " type=\"text\"> </input><br><br><br>");
							break;
						}
					default:
						{
							container = $("<button id=" + guid() + ">" + type + "</button>");
							break;
						}
					}
					// $(container).text(ui.draggable.text()).appendTo(this);
					$(container).appendTo(this);
				}
		});
	});