<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<sch:ReferenciaFactura xmlns:sch="http://www.servicios.co/pagos/schemas">
			<sch:referenciaFactura><xsl:value-of select="serviceId"/></sch:referenciaFactura>
		</sch:ReferenciaFactura>
	</xsl:template>
</xsl:stylesheet>

