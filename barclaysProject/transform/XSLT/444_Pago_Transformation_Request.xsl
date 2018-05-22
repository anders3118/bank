<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<sch:Pago xmlns:sch="http://www.servicios.co/pagos/schemas">
			<sch:referenciaFactura>
				<sch:referenciaFactura>
					<xsl:value-of select="root/serviceId" />
				</sch:referenciaFactura>
			</sch:referenciaFactura>
			<sch:totalPagar>
				<xsl:value-of select="root/billValue" />
			</sch:totalPagar>
		</sch:Pago>
	</xsl:template>
</xsl:stylesheet>