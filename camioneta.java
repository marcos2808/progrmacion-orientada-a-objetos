package camioneta;
public class camioneta {
	int anchodeChasis;
	int largodeChasis;
	int peso;
	int cauchos;
	int Asientos;
	String traccion;
	int anofabricacion;
	String calefaccion;
	String Asientosdetela;
	String marca;
	String modelo;
	
	public camioneta() {
		anchodeChasis = 260;
		largodeChasis = 766;
		peso = 3150;
		cauchos = 4;
		Asientos = 4;
		
	}
	public void pedirTraccion(String traccion) {
		this.traccion = traccion;
		
	}
	public void pedirAnofabricacion(int anofabricacion) {
		this.anofabricacion = anofabricacion;
		
	}
	public void pedircalefaccion(String calefaccion) {
		this.calefaccion = calefaccion;
	}
	public void pedirAsientosdetela(String Asientosdetela) {
		this.Asientosdetela = Asientosdetela;
		
	}
	public void pedirMarca(String marca) {
		this.marca = marca;
	}
	public void pedirModelo(String modelo) {
		this.modelo = modelo;
	}
	public String darAnchodechasis() {
		return "\n su chasis tiene un ancho de "+ anchodeChasis;
	}
	public String darlargodeChasis() {
		return "\n su chasis tiene un largo de "+ largodeChasis; 
	}
	public String darpeso() {
		return "\n el peso es de"+ peso;
		
	}
	public String darCauchos() {
		return "\n la camioneta tiene "+ cauchos +" cauchos";
		
	}
	public String darAsientos() {
		return "\n el numero de asientos es de "+ Asientos;
	}
	public String dartraccion() {
		return "\n la camioneta es "+ traccion;
		
	}
	public String daranofabricacion() {
		return "\n su fabricaccion fue en "+ anofabricacion;
		
	}
	public String darCalefaccion() {
		return "\n la camioneta "+ calefaccion +"tiene calefaccion";
	}
	public String darAsientosdetela() {
		return "\n la camioneta"+ Asientosdetela +"tiene asientos de tela";
	}
	public String darMarca() {
		return "\n la marca de su camioneta es "+ marca;
	}
	public String darModelo() {
		return "\n su camioneta es modelo"+ modelo;
	}
	public String darEspecificaciones() {
		return darAnchodechasis()+ darlargodeChasis()+ darpeso()+ darCauchos()+ darAsientos()+ dartraccion()+ daranofabricacion()+ darCalefaccion()+ darAsientosdetela()+ darMarca()+ darModelo(); 
	}
}