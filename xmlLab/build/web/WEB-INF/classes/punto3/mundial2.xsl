<?xml version='1.0' encoding="ISO8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="equipos">
        <html>
            <body style="background-color:black">
                <h1 style="color: white">Equipos del Mundial</h1>
                <table bgcolor="#03A9F4" border="3" style="font-style: italic; color:white;">
                    <tr>
                        <th>Pais</th>
                        <th>Grupo</th>
                        <th>Posicion</th>
                    </tr>
                    
                    <xsl:for-each select="equipo">
                        <tr>
                            <td>
                                <xsl:value-of select="pais"/>
                            </td>
                            <td>
                                <xsl:value-of select="grupo"/>
                            </td>
                            <td>
                                <xsl:value-of select="pais/@posicion"/>
                            </td>
                        </tr>
                    </xsl:for-each> 
                </table>
            </body>
        </html>
    </xsl:template>
        
</xsl:stylesheet>
