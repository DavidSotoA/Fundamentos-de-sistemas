<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
                  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
                  crossorigin="anonymous"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJAX with JSON</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).ready(function(){
                $("#boton").click(function(){
                    
                    $("#tablaPaises").append(
                     "<tr>"+
				"<td><strong>Code</strong></td>"+
				"<td><strong>Name</strong></td>"+
				"<td><strong>Continent</strong></td>"+
                                "<td><strong>Region</strong></td>"+
                                "<td><strong>Population</strong></td>"+
                                "<td><strong>Capital</strong></td>"+
			"</tr>"   
                    );
                    $.get('PaisesServlet', {},function(resp){
                        $.each(resp, function(i, pais) {
                            $("#tablaPaises").append(
                            "<tr>"+
                                       "<td>"+pais.code+"</td>"+
                                       "<td>"+pais.name+"</td>"+
                                       "<td>"+pais.continent+"</td>"+
                                       "<td>"+pais.region+"</td>"+
                                       "<td>"+pais.population+"</td>"+
                                       "<td>"+pais.capital+"</td>"+
                               "</tr>"   
                           );

                        });
                    });    
                }); 
            });
        </script>
    </head>
    <body>
        <div style="text-align: center" id="div">
            <h1>AJAX Retrieve Data from Database in Servlet and JSP using JSONArray</h1>
            <button id="boton">Show Table</button><br/><br/>
            <div class="table-responsive">
            <table id="tablaPaises" class="table table-striped" >

            </table>
            </div>
        </div>
    </body>
</html>
