<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="http://www.servicios.co/pagos/schemas">
			<soapenv:Header/>
			<soapenv:Body>
				<sch:ReferenciaFactura xmlns:sch="http://www.servicios.co/pagos/schemas">
					<sch:referenciaFactura>
						<xsl:value-of select="root/serviceId"/>
					</sch:referenciaFactura>
				</sch:ReferenciaFactura>
			</soapenv:Body>
		</soapenv:Envelope>		
	</xsl:template>
</xsl:stylesheet>