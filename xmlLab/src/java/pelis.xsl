<?xml version='1.0' encoding="ISO8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
  <title>Formateando con XSLT</title>
<style>BODY,TD{font-family:verdana;font-size:10px}</style>
  </head>
  <body>
    <table cellspacing="0" cellpadding="10" align="center" width="300">
      <xsl:for-each select="TRAILERS/PELICULA" order-by="+TITULO">
      <tr>
        <td bgcolor="yellow" valign="top">
	<!--aqui va la imagen-->
	<IMG WIDTH="134" HEIGHT="193">
	<xsl:attribute name="src">
	   <xsl:value-of select="CARTEL"/>
	</xsl:attribute>
	</IMG>
	<!--fin de la imagen-->
	</td>
	<td bgcolor="yellow" valign="top">
	<!--aqui va el enlace-->
	<P><B><FONT SIZE="2">
	<a>
	<xsl:attribute name="href">
	   <xsl:value-of select="URL"/>
	</xsl:attribute>
	<xsl:attribute name="title">Pulsa para ver el trailer de <xsl:value-of select="TITULO"/></xsl:attribute>
	<xsl:value-of select="TITULO"/>
	</a></FONT></B><!--fin del enlace-->
	</P>
	<P>
	<xsl:value-of select="GENERO"/></P>
	<P><xsl:value-of select="TEMA"/></P></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

