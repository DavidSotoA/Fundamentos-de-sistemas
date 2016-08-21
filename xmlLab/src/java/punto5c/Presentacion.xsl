<?xml version='1.0' encoding="ISO8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="libros">
        <html>
            <head>
                <meta charuset="utf-8"/>
                <title>Mis libros</title>
            </head>
            
            <body>
                <table border="3">
                    <tr style="background-color:#03A9F4">
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>ISBN</th>
                        <th>Año</th>
                    </tr>
                    <xsl:for-each select="libro">
                        <tr>
                            <td>
                                <xsl:value-of select="titulo"/>
                            </td>
                            <td>
                                <xsl:value-of select="autor"/>
                            </td>
                            <td>
                                <xsl:value-of select="isbn"/>
                            </td>
                            <td>
                                <xsl:value-of select="ano"/>
                            </td>
                        </tr>
                    </xsl:for-each> 
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
