package dto;

public class PersonaDTO {
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private String nacimiento;
	private int domicilio;
	private DomicilioDTO domicilioDTO;
	private int idTipoContacto;
	private String tipoContacto;
	private LocalidadDTO localidad;
	private String mesNacimiento;
	private String plataformaAlmacenamiento;

	public PersonaDTO(int idPersona, String nombre, String telefono, String email, String nacimiento, int domicilio,
			int idTipoContacto, String mesNacimiento, String plataformaAlmacenamiento) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.nacimiento = nacimiento;
		this.domicilio = domicilio;
		this.idTipoContacto = idTipoContacto;
		this.mesNacimiento = mesNacimiento;
		this.plataformaAlmacenamiento = plataformaAlmacenamiento;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(int domicilio) {
		this.domicilio = domicilio;
	}

	public DomicilioDTO getDomicilioDTO() {
		return domicilioDTO;
	}

	public int getIdTipoContacto() {
		return idTipoContacto;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public void setDomicilioDTO(DomicilioDTO domicilioDTO) {
		this.domicilioDTO = domicilioDTO;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

	public String getMesNacimiento() {
		return mesNacimiento;
	}

	public void setMesNacimiento(String mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
	}

	public String getPlataformaAlmacenamiento() {
		return plataformaAlmacenamiento;
	}

	public void setPlataformaAlmacenamiento(String plataformaAlmacenamiento) {
		this.plataformaAlmacenamiento = plataformaAlmacenamiento;
	}
}
