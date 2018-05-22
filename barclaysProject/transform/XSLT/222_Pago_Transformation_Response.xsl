<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<serviceId><xsl:value-of select="Envelope/Body/ResultadoConsulta/referenciaFactura/referenciaFactura"/></serviceId>
		<messageStatus><xsl:value-of select="Envelope/Body/ResultadoConsulta/totalPagar"/></messageStatus>
	</xsl:template>
</xsl:stylesheet>