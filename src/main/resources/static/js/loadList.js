    $.getJSON('/list',
        function(data) {
			data.forEach(function(activity) {
					
					var s = "<tr>"+"<td>"+activity.name+"</td><td>"+activity.department+"</td><td>";
					
					for(var i=0;i<activity.tags.length;i++) {
						if(i == (activity.tags.length-1)) {
							s += activity.tags[i];
						}
						else {
							s += activity.tags[i] + ", ";
						}
					}
					$('#startcolumn').append(s+"</td><td>"+activity.description+"</td><td>"+"<a href=\"/activity?id="+activity.id+"\">details</a>"+"</td></tr>");
			});
    });
    
