<%-- 
    Document   : inicio
    Created on : 26/08/2016, 11:11:29 AM
    Author     : pipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Llamadas AJAX a un Servlet usando JQUERY Y JSON</title>

        <script src="http://code.jquery.com/jquery-latest.min.js"></script>

        <script>

            $(document).ready(function () {

                $('#country').change(function (event) {

                    var $country = $("select#country").val();

                    $.get('ActionServlet', {countryname: $country}, function (responseJson) {

                        var $select = $('#states');

                        $select.find('option').remove();

                        $.each(responseJson, function (key, value) {

                            $('<option>').val(key).text(value).appendTo($select);

                        });

                    });

                });

            });

        </script>

    </head>

    <body>

        <h1>Llamadas AJAX a un Servlet usando JQUERY Y JSON</h1>

        Select Country:

        <select id="country">

            <option>Select Country</option>

            <option value="Colombia">Colombia</option>

            <option value="US">US</option>

        </select>

        <br/>

        <br/>

        Select State:

        <select id="states">

            <option>Select State</option>

        </select>

    </body>

</html>
