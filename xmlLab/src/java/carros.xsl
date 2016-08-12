<?xml version='1.0' encoding="ISO8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
      <html>

        <head>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
                  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
                  crossorigin="anonymous"/>
            <title>Catalogo de carros</title>
            <style>
                .bodycss{background-color: #BDBDBD;
                        padding-bottom: 40px;
                        }
            
                div.carro{margin-top: 50px;
                        padding-top: 20px;
                        padding-bottom: 20px;
                        background-color: white;
                        border-style: solid;
                        border-width: 1px;
                        border-radius: 4px;
                        }
            </style>
        </head>

        <body class="bodycss">    
            <div class="container-fluid" >
                <xsl:for-each select="catalogo/carros/carro">
                  <xsl:sort select="precio" order="ascending"/>
                  <div  class="row">
                      <div class="col-xs-10 col-xs-offset-1 carro">
                          <div  class="row" >
                              <div class="col-xs-6">
                                  <img higth="100%" width="100%" class="img-responsive img-rounded">
                                      <xsl:attribute name="src">
                                         <xsl:value-of select="imagen"/>
                                      </xsl:attribute>
                                  </img>
                              </div>

                              <div class="col-xs-6">
                                  <h3><xsl:value-of select="datos/marca"/></h3>
                                  <p>
                                      <strong>Modelo: </strong>
                                      <xsl:value-of select="modelo"/>
                                  </p> 
                                  <p>
                                      <strong>Kilometraje: </strong>
                                      <xsl:value-of select="datos/kilometraje"/>
                                  </p> 
                                  <p>
                                      <strong>Tracción: </strong>
                                      <xsl:value-of select="datos/traccion"/>
                                  </p> 
                                  <p>
                                      <strong>Tipo de motor: </strong>
                                      <xsl:value-of select="datos/tipo_motor"/>
                                  </p> 
                                  <p>
                                      <strong>Puertas: </strong>
                                      <xsl:value-of select="datos/puertas"/>
                                  </p> 
                                  <p>
                                      <strong>Puestos: </strong>
                                      <xsl:value-of select="datos/puestos"/>
                                  </p> 
                                  <p>
                                      <strong>Precio: $</strong>
                                      <xsl:value-of select="precio"/>
                                  </p> 
                                  <br/><br/><br/><br/><br/>
                                  
                                  <div class="col-xs-12">
                                      <button type="button" class="btn btn-primary btn-block">Solicitar cotizacion</button>
                                  </div>                                 
                              </div>
                          </div>
                      </div>
                  </div>
                </xsl:for-each>
            </div>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>