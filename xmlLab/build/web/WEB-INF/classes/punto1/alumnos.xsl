<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="alumnos">
        <html>
            <head>
                <title>Informacion de Alumnos</title>
            </head>
            <body>
                <h1>Lista de alumnos</h1>
                
                <table border="2px">
                    <tr>
                        <td><strong>DNI</strong></td>
                        <td><strong>Nombre</strong></td>
                        <td><strong>Apellidos</strong></td>
                        <td><strong>Nota</strong></td>
                        <td><strong>Email</strong></td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="alumno">
        <tr>
            <td>
            <xsl:value-of select="@dni"/>
            </td>
            <td>
            <xsl:value-of select="nombre"/>
            </td>
             <td>
            <xsl:value-of select="apellidos"/>
            </td>
             <td>
            <xsl:value-of select="nota"/>
            </td>
             <td>
            <xsl:value-of select="email"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>