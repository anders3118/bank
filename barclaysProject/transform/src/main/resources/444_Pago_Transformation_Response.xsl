<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<serviceId><xsl:value-of select="Resultado/referenciaFactura/referenciaFactura"/></serviceId>
		<messageStatus><xsl:value-of select="Resultado/mensaje"/></messageStatus>
	</xsl:template>
</xsl:stylesheet>