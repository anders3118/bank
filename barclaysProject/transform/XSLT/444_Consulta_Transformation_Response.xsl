<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<serviceId><xsl:value-of select="ResultadoConsulta/referenciaFactura/referenciaFactura"/></serviceId>
		<value><xsl:value-of select="ResultadoConsulta/totalPagar"/></value>
	</xsl:template>
</xsl:stylesheet>