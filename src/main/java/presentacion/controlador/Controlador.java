package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaUbicacionUpdate;
import presentacion.vista.VentanaPersonaUpdate;
import presentacion.vista.VentanaTipoDeContactoUpdate;
import presentacion.vista.VentanaUbicacioneInsert;
import presentacion.vista.VentanaTipoDeContactoInsert;
import presentacion.vista.VentanaPersonaInsert;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private List<LocalidadDTO> localidadesEnTabla;
	private List<TipoDeContactoDTO> tipoDeContactoEnTabla;
	private VentanaPersonaInsert ventanaPersonaInsert;
	private VentanaPersonaUpdate ventanaPersonaUpdate;
	private VentanaUbicacioneInsert ventanaUbicacionInsert;
	private VentanaUbicacionUpdate ventanaUbicacionUpdate;
	private VentanaTipoDeContactoInsert ventanaTipoDeContactoInsert;
	private VentanaTipoDeContactoUpdate ventanaTipoDeContactoUpdate;
	private PersonaDTO personaSeleccionada;
	private LocalidadDTO localidadSeleccionada;
	private TipoDeContactoDTO tipoDeContactoSeleccionado;
	private Agenda agenda;
	Pattern ptremail = Pattern.compile(
			"(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");

	public Controlador(Vista vista, Agenda agenda) {
		// Vista mapping
		this.vista = vista;
		this.agenda = agenda;
		this.vista.getBtnAgregar().addActionListener(a -> ventanaInsert(a));
		this.vista.getBtnBorrar().addActionListener(s -> borrar(s));
		this.vista.getBtnReporteMesNacimiento().addActionListener(r -> mostrarReporte(r, "ReporteAgenda1.jasper"));
		this.vista.getBtnReportePlataformaAlmacenamiento()
				.addActionListener(r -> mostrarReporte(r, "ReporteAgenda2.jasper"));
		this.vista.getBtnEditar().addActionListener(e -> ventanaUpdate(e));
		this.vista.getBtnVerAgenda().addActionListener(c -> cargarTablaPersonas(c));
		this.vista.getBtnLocalidades().addActionListener(c -> cargarTablaLocalidades(c));
		this.vista.getBtnVerTipoDeContacto().addActionListener(c -> cargarTablaTipoDeContacto(c));

		// Ventana Persona
		this.ventanaPersonaInsert = VentanaPersonaInsert.getInstance();
		this.ventanaPersonaInsert.getBtnAgregarPersona().addActionListener(p -> guardar(p));
		this.ventanaPersonaUpdate = VentanaPersonaUpdate.getInstance();
		this.ventanaPersonaUpdate.getBtnGuardarPersona().addActionListener(g -> editar(g));

		// Ventana Ubicaciones
		this.ventanaUbicacionInsert = VentanaUbicacioneInsert.getInstance();
		this.ventanaUbicacionUpdate = VentanaUbicacionUpdate.getInstance();
		this.ventanaUbicacionInsert.getBtnAgregarLocalidad().addActionListener(l -> guardar(l));
		this.ventanaUbicacionUpdate.getBtnEditarLocalidad().addActionListener(l -> editar(l));

		// Ventana Tipo Contacto
		this.ventanaTipoDeContactoInsert = VentanaTipoDeContactoInsert.getInstance();
		this.ventanaTipoDeContactoUpdate = VentanaTipoDeContactoUpdate.getInstance();
		this.ventanaTipoDeContactoInsert.getBtnAgregarTipoDeContacto().addActionListener(t -> guardar(t));
		this.ventanaTipoDeContactoUpdate.getBtnEditarTipoDeContacto().addActionListener(t -> editar(t));
	}

	private void ventanaInsert(ActionEvent a) {
		this.ventanaPersonaInsert.llenarTiposDeContacto(agenda.obtenerTiposDeContacto());
		this.ventanaPersonaInsert.llenarLocalidades(agenda.obtenerLocalidades());
		this.ventanaPersonaInsert.llenarComboMesNacimiento();

		if (this.vista.getVistaSeleccionada() == 1) {
			this.ventanaPersonaInsert.mostrarVentana();
		}

		if (this.vista.getVistaSeleccionada() == 2) {
			this.ventanaUbicacionInsert.mostrarVentana();
		}

		if (this.vista.getVistaSeleccionada() == 3) {
			this.ventanaTipoDeContactoInsert.mostrarVentana();
		}
	}

	public void ventanaUpdate(ActionEvent e) {
		if (this.vista.getTablaPersonas() != null && this.vista.getTablaPersonas().getSelectedRow() != -1) {
			this.ventanaPersonaUpdate.llenarTiposDeContacto(agenda.obtenerTiposDeContacto());
			this.ventanaPersonaUpdate.llenarLocalidades(agenda.obtenerLocalidades());
			this.ventanaPersonaUpdate.llenarComboMesNacimiento();
			int filaSeleccionada = this.vista.getTablaPersonas().getSelectedRow();

			if (this.vista.getVistaSeleccionada() == 1) {
				personaSeleccionada = this.personasEnTabla.get(filaSeleccionada);
				TipoDeContactoDTO tipoDTO = this.agenda.getTipoContacto(personaSeleccionada.getIdTipoContacto());
				LocalidadDTO localidadDTO = this.agenda
						.getLocalidad(personaSeleccionada.getLocalidad().getIdLocalidad());
				this.ventanaPersonaUpdate.llenarInfoPersona(personaSeleccionada, tipoDeContactoEnTabla,
						localidadesEnTabla, tipoDTO, localidadDTO);
				this.ventanaPersonaUpdate.mostrarVentana();
			}

			if (this.vista.getVistaSeleccionada() == 2) {
				localidadSeleccionada = this.localidadesEnTabla.get(filaSeleccionada);
				this.ventanaUbicacionUpdate.llenarInfoLocalidad(localidadSeleccionada);
				this.ventanaUbicacionUpdate.mostrarVentana();
			}

			if (this.vista.getVistaSeleccionada() == 3) {
				tipoDeContactoSeleccionado = this.tipoDeContactoEnTabla.get(filaSeleccionada);
				this.ventanaTipoDeContactoUpdate.llenarInfoTipoDeContacto(tipoDeContactoSeleccionado);
				this.ventanaTipoDeContactoUpdate.mostrarVentana();
			}
		}

	}

	private void guardar(ActionEvent p) {
		if (this.vista.getVistaSeleccionada() == 1) {
			String nombre = this.ventanaPersonaInsert.getTxtNombre().getText();
			String tel = ventanaPersonaInsert.getTxtTelefono().getText();
			String email = this.ventanaPersonaInsert.getEmail().getText();
			String nacimiento = this.ventanaPersonaInsert.getNacimiento().getText();
			String plataformaAlmacenamiento = this.ventanaPersonaInsert.getPlataformaAlmacenamiento().getText();
			int domicilio = this.guardarDomicilio();
			int tipoContacto = Integer.parseInt(
					this.ventanaPersonaInsert.getTipoDeContactos().getSelectedItem().toString().substring(0, 1));
			String mesNacimiento = (String) this.ventanaPersonaInsert.getMesNacimiento().getSelectedItem();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, nacimiento, domicilio, tipoContacto,
					mesNacimiento, plataformaAlmacenamiento);

			if (nombre.isEmpty() || tel.equals("(___) ____-____") || email.isEmpty()
					|| nacimiento.equals("____-__-__")) {
				JOptionPane.showMessageDialog(this.ventanaPersonaInsert,
						"El contacto debe tener al menos Nombre, Telefono, Fecha de Nacimiento y Email.");
			} else if (!ptremail.matcher(email).matches()) {
				JOptionPane.showMessageDialog(this.ventanaPersonaInsert, "Formato invalido de Email.");
			} else {
				this.agenda.agregarPersona(nuevaPersona);
				this.refrescarTabla();
				this.ventanaPersonaInsert.cerrar();
			}
		}

		if (this.vista.getVistaSeleccionada() == 2) {
			if (this.ventanaUbicacionInsert.getLocalidad().getText().trim().isEmpty()) {
				return;
			}
			String localidad = ventanaUbicacionInsert.getLocalidad().getText();
			String provincia = ventanaUbicacionInsert.getProvincia().getText();
			String pais = ventanaUbicacionInsert.getPais().getText();
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, localidad, provincia, pais);
			this.agenda.agregarLocalidad(nuevaLocalidad);
			this.refrescarTablaLocalidades();
			this.ventanaUbicacionInsert.cerrar();
		}

		if (this.vista.getVistaSeleccionada() == 3) {
			if (this.ventanaTipoDeContactoInsert.getTipoDeContacto().getText().trim().isEmpty()) {
				return;
			}
			String tipoDeContacto = ventanaTipoDeContactoInsert.getTipoDeContacto().getText();
			TipoDeContactoDTO nuevoTipo = new TipoDeContactoDTO(0, tipoDeContacto);
			this.agenda.agregarTipoDeContacto(nuevoTipo);
			this.refrescarTablaTiposDeContacto();
			this.ventanaTipoDeContactoInsert.cerrar();
		}
	}

	private void editar(ActionEvent g) {
		if (this.vista.getVistaSeleccionada() == 1) {
			String nombre = this.ventanaPersonaUpdate.getTxtNombre().getText();
			String tel = ventanaPersonaUpdate.getTxtTelefono().getText();
			String email = this.ventanaPersonaUpdate.getEmail().getText();
			String nacimiento = ventanaPersonaUpdate.getNacimiento().getText();
			int domicilio = this.guardarCambiosDomicilio(personaSeleccionada.getDomicilio());
			int tipo = Integer.parseInt(
					this.ventanaPersonaUpdate.getTipoDeContactos().getSelectedItem().toString().substring(0, 1));
			String mesNacimiento = (String) this.ventanaPersonaUpdate.getMesNacimiento().getSelectedItem();
			String plataformaAlmacenamiento = this.ventanaPersonaUpdate.getPlataformaAlmacenamiento().getText();

			PersonaDTO personaActualizada = new PersonaDTO(personaSeleccionada.getIdPersona(), nombre, tel, email,
					nacimiento, domicilio, tipo, mesNacimiento, plataformaAlmacenamiento);

			if (nombre.isEmpty() || tel.equals("(___) ____-____") || email.isEmpty()
					|| nacimiento.equals("____-__-__")) {
				JOptionPane.showMessageDialog(this.ventanaPersonaInsert,
						"El contacto debe tener al menos Nombre, Telefono, Fecha de Nacimiento y Email.");
			} else if (!ptremail.matcher(email).matches()) {
				JOptionPane.showMessageDialog(this.ventanaPersonaInsert, "Formato invalido de Email.");
			} else {
				this.agenda.actualizarPersona(personaActualizada);
				this.refrescarTabla();
				this.ventanaPersonaUpdate.cerrar();
			}
		}

		if (this.vista.getVistaSeleccionada() == 2) {
			if (this.ventanaUbicacionUpdate.getLocalidad().getText().trim().isEmpty()) {
				return;
			}
			String localidad = ventanaUbicacionUpdate.getLocalidad().getText();
			String provincia = ventanaUbicacionUpdate.getProvincia().getText();
			String pais = ventanaUbicacionUpdate.getPais().getText();
			LocalidadDTO localidadActualizada = new LocalidadDTO(localidadSeleccionada.getIdLocalidad(), localidad,
					provincia, pais);
			this.agenda.actualizarLocalidad(localidadActualizada);
			this.refrescarTablaLocalidades();
			this.ventanaUbicacionUpdate.cerrar();
		}

		if (this.vista.getVistaSeleccionada() == 3) {
			if (this.ventanaTipoDeContactoUpdate.getTipoDeContacto().getText().trim().isEmpty()) {
				return;
			}

			String tipo = ventanaTipoDeContactoUpdate.getTipoDeContacto().getText();
			TipoDeContactoDTO tipoNuevo = new TipoDeContactoDTO(tipoDeContactoSeleccionado.getIdTipoDeContacto(), tipo);
			this.agenda.actualizarTipoDeContacto(tipoNuevo);
			this.refrescarTablaTiposDeContacto();
			this.ventanaTipoDeContactoUpdate.cerrar();
		}
	}

	private int guardarDomicilio() {
		String calle = this.ventanaPersonaInsert.getCalle().getText();
		String altura = ventanaPersonaInsert.getAltura().getText();
		String depto = this.ventanaPersonaInsert.getDepto().getText();
		String piso = ventanaPersonaInsert.getPiso().getText();
		int localidad = Integer
				.parseInt(this.ventanaPersonaInsert.getLocalidad().getSelectedItem().toString().substring(0, 1));
		if (calle != null || altura != null || depto != null || piso != null) {
			DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, calle, altura, piso, depto, localidad);
			return this.agenda.agregarDomicilio(nuevoDomicilio);
		}
		return 0;
	}

	private int guardarCambiosDomicilio(int id) {
		String calle = this.ventanaPersonaUpdate.getCalle().getText();
		String altura = ventanaPersonaUpdate.getAltura().getText();
		String tipoD = this.ventanaPersonaUpdate.getDepto().getText();
		String piso = ventanaPersonaUpdate.getPiso().getText();
		int localidad = Integer
				.parseInt(this.ventanaPersonaUpdate.getLocalidad().getSelectedItem().toString().substring(0, 1));
		DomicilioDTO Domicilio = new DomicilioDTO(id, calle, altura, piso, tipoD, localidad);
		return this.agenda.actualizarDomicilio(Domicilio);
	}

	private void mostrarReporte(ActionEvent r, String reportepath) {
		String orden = (String) this.vista.getComboSort().getSelectedItem();
		ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas(), reportepath, orden);
		reporte.mostrar();
	}

	public void borrar(ActionEvent s) {
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		if (this.vista.getVistaSeleccionada() == 1) {
			for (int fila : filasSeleccionadas) {
				PersonaDTO persona = this.personasEnTabla.get(fila);
				this.agenda.borrarPersona(persona);
				this.agenda.borrarDomicilio(persona.getDomicilioDTO());
			}
			this.refrescarTabla();
		}

		if (this.vista.getVistaSeleccionada() == 2) {
			for (int fila : filasSeleccionadas) {
				this.agenda.borrarLocalidad(this.localidadesEnTabla.get(fila));
			}
			this.refrescarTablaLocalidades();
		}

		if (this.vista.getVistaSeleccionada() == 3) {
			for (int fila : filasSeleccionadas) {
				this.agenda.borrarTipoDeContacto(this.tipoDeContactoEnTabla.get(fila));
			}
			this.refrescarTablaTiposDeContacto();
		}
	}

	public void cargarTablaPersonas(ActionEvent c) {
		this.vista.setVistaSeleccionada(1);
		this.vista.cargarVistaPersona();
		showReportPanel();
		this.vista.cargarTablaPersonas();
		refrescarTabla();
	}

	public void cargarTablaLocalidades(ActionEvent c) {
		this.vista.setVistaSeleccionada(2);
		this.vista.cargarVistaLocalidad();
		cleanReportPanel();
		this.vista.cargarTablaLocalidades();
		refrescarTablaLocalidades();
	}

	public void cargarTablaTipoDeContacto(ActionEvent c) {
		this.vista.setVistaSeleccionada(3);
		this.vista.cargarVistaTipoContacto();
		cleanReportPanel();
		this.vista.cargarTablaTipodeContacto();
		refrescarTablaTiposDeContacto();
	}

	private void cleanReportPanel() {
		this.vista.getBtnReporteMesNacimiento().setVisible(false);
		this.vista.getBtnReportePlataformaAlmacenamiento().setVisible(false);
		this.vista.getComboSort().setVisible(false);
		this.vista.getLblOrden().setVisible(false);
	}

	private void showReportPanel() {
		this.vista.getBtnReporteMesNacimiento().setVisible(true);
		this.vista.getBtnReportePlataformaAlmacenamiento().setVisible(true);
		this.vista.getComboSort().setVisible(true);
		this.vista.getLblOrden().setVisible(true);
	}

	private void refrescarTablaLocalidades() {
		this.localidadesEnTabla = agenda.obtenerLocalidades();
		this.vista.llenarTablaLocalidades(localidadesEnTabla);
	}

	private void refrescarTablaTiposDeContacto() {
		this.tipoDeContactoEnTabla = agenda.obtenerTiposDeContacto();
		this.vista.llenarTablaTiposDeContacto(tipoDeContactoEnTabla);
	}

	private void refrescarTabla() {
		this.personasEnTabla = agenda.obtenerPersonas();
		for (PersonaDTO p : this.personasEnTabla) {
			setDomicilio(p);
			setTipoContacto(p);
			setLocalidad(p);
		}
		this.vista.llenarTabla(this.personasEnTabla);
	}

	public void inicializar() {
		this.tipoDeContactoEnTabla = agenda.obtenerTiposDeContacto();
		this.localidadesEnTabla = agenda.obtenerLocalidades();
		this.refrescarTabla();
		this.vista.show();
	}

	private void setLocalidad(PersonaDTO p) {
		p.setLocalidad(this.agenda.getLocalidad(p.getDomicilioDTO().getLocalidad()));
	}

	private void setTipoContacto(PersonaDTO p) {
		p.setTipoContacto(this.agenda.getTipoContacto(p.getIdTipoContacto()).getTipoDeContacto());
	}

	private void setDomicilio(PersonaDTO p) {
		p.setDomicilioDTO(this.agenda.getDomicilio(p.getDomicilio()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
