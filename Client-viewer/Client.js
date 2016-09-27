var stockageListeC;

function test()
    {
        $.get('http://localhost:8080/pizzeria-spring/api/clients', function(clientsTab){
            stockageListeC = clientsTab;
			clientsTab.forEach(function(client){
				
				$("#tabClients").append("<tr>");
				$("#tabClients").append("<td>"+client.id+"</td>");
				$("#tabClients").append("<td>"+client.nom+"</td>");
                $("#tabClients").append("<td>"+client.prenom+"</td>");
                $("#tabClients").append("<td>"+client.solde+"</td>");
				
				$("#tabClients").append("<td><a href='#' class='btn btn-primary btnView' data='"+ client.id +"'>Debiter</a></td>");
                $("#tabClients").append("<td><a href='#' class='btn btn-primary btnView' data='"+ client.id +"'>Crediter</a></td>");
				$("#tabClients").append("</tr>");
			});
			
        })
       
    };

    test();