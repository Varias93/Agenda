package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class VentanaPersonaUpdate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private static VentanaPersonaUpdate INSTANCE;
	private JTextField txtNacimiento;
	private JTextField txtEmail;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtPlataformaAlmacenamiento;
	private JComboBox<String> tipoDeContactos;
	private JComboBox<String> localidad;
	private JComboBox<String> jComboBoxMesNacimiento;
	private DefaultComboBoxModel<String> modelTiposContacto = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelLocalidades = new DefaultComboBoxModel<String>();
	private JButton btnGuardarPersona;
	protected MaskFormatter mask_tel;
	protected MaskFormatter mask_fec;

	public static VentanaPersonaUpdate getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VentanaPersonaUpdate();
			return new VentanaPersonaUpdate();
		} else
			return INSTANCE;
	}

	private VentanaPersonaUpdate() {
		super();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrar();
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(java.awt.Color.GRAY);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaNacimiento = new JLabel("Nacimiento");
		lblFechaNacimiento.setBounds(10, 134, 113, 14);
		panel.add(lblFechaNacimiento);

		JLabel lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setBounds(10, 175, 113, 14);
		panel.add(lblTipoContacto);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 216, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 257, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 298, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 339, 113, 14);
		panel.add(lblDepto);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 380, 113, 14);
		panel.add(lblLocalidad);

		JLabel lblPlataformaAlmacenamiento = new JLabel("Plataforma de Alm.");
		lblPlataformaAlmacenamiento.setBounds(10, 421, 113, 14);
		panel.add(lblPlataformaAlmacenamiento);

		JLabel lblMesNacimiento = new JLabel("Mes de Nacimiento");
		lblMesNacimiento.setBounds(10, 462, 113, 14);
		panel.add(lblMesNacimiento);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		try {
			mask_tel = new MaskFormatter("(###) ####-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mask_tel.setPlaceholderCharacter('_');

		txtTelefono = new JFormattedTextField(mask_tel);
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		try {
			mask_fec = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mask_fec.setPlaceholderCharacter('_');

		txtNacimiento = new JFormattedTextField(mask_fec);
		txtNacimiento.setBounds(133, 131, 164, 20);
		panel.add(txtNacimiento);
		txtNacimiento.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(133, 90, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setBounds(133, 213, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);

		txtAltura = new JFormattedTextField(format);
		txtAltura.setBounds(133, 254, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);

		txtPiso = new JFormattedTextField(format);
		txtPiso.setBounds(133, 295, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);

		txtDepto = new JTextField();
		txtDepto.setBounds(133, 336, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);

		DefaultComboBoxModel<String> model = this.getModelTipos();
		tipoDeContactos = new JComboBox<String>(model);
		tipoDeContactos.setBounds(133, 171, 164, 20);
		panel.add(tipoDeContactos);

		DefaultComboBoxModel<String> modelLocalidad = this.getModelLocalidades();
		localidad = new JComboBox<String>(modelLocalidad);
		localidad.setModel(modelLocalidad);
		localidad.setBounds(133, 377, 164, 20);
		panel.add(localidad);

		txtPlataformaAlmacenamiento = new JTextField();
		txtPlataformaAlmacenamiento.setBounds(133, 418, 164, 20);
		panel.add(txtPlataformaAlmacenamiento);
		txtPlataformaAlmacenamiento.setColumns(10);

		jComboBoxMesNacimiento = new JComboBox<String>();
		jComboBoxMesNacimiento.setBounds(133, 459, 164, 20);
		panel.add(jComboBoxMesNacimiento);

		btnGuardarPersona = new JButton("Guardar");
		btnGuardarPersona.setBounds(141, 500, 89, 23);
		panel.add(btnGuardarPersona);

		this.setVisible(false);
	}

	public void mostrarVentana() {
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getNacimiento() {
		return txtNacimiento;
	}

	public void setNacimiento(JTextField nacimiento) {
		this.txtNacimiento = nacimiento;
	}

	public JTextField getEmail() {
		return txtEmail;
	}

	public void setEmail(JTextField email) {
		this.txtEmail = email;
	}

	public JTextField getCalle() {
		return txtCalle;
	}

	public void setCalle(JTextField calle) {
		this.txtCalle = calle;
	}

	public JTextField getAltura() {
		return txtAltura;
	}

	public void setAltura(JTextField altura) {
		this.txtAltura = altura;
	}

	public JTextField getPiso() {
		return txtPiso;
	}

	public void setPiso(JTextField piso) {
		this.txtPiso = piso;
	}

	public JTextField getDepto() {
		return txtDepto;
	}

	public void setDepto(JTextField nacimiento) {
		this.txtNacimiento = nacimiento;
	}

	public void cerrar() {
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtNacimiento.setText(null);
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDepto.setText(null);
		this.dispose();
	}

	public void llenarTiposDeContacto(List<TipoDeContactoDTO> tiposDeContacto) {
		this.getModelTipos().removeAllElements();
		for (TipoDeContactoDTO t : tiposDeContacto) {
			this.getModelTipos().addElement(t.getIdTipoDeContacto() + " - " + t.getTipoDeContacto());
		}

	}

	public void llenarLocalidades(List<LocalidadDTO> localidades) {
		this.getModelLocalidades().removeAllElements();
		for (LocalidadDTO l : localidades) {
			this.getModelLocalidades().addElement(l.getIdLocalidad() + " - " + l.getNombreLocalidad());
		}

	}

	public void llenarComboMesNacimiento() {
		this.jComboBoxMesNacimiento.removeAllItems();
		String[] Meses = new String[] { " ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre" };
		for (String mes : Meses)
			jComboBoxMesNacimiento.addItem(mes);
	}

	public DefaultComboBoxModel<String> getModelTipos() {
		return modelTiposContacto;
	}

	public void setModelTipos(DefaultComboBoxModel<String> modelTipos) {
		this.modelTiposContacto = modelTipos;
	}

	public DefaultComboBoxModel<String> getModelLocalidades() {
		return modelLocalidades;
	}

	public void setModelLocalidades(DefaultComboBoxModel<String> modelLocalidades) {
		this.modelLocalidades = modelLocalidades;
	}

	public JComboBox<String> getTipoDeContactos() {
		return tipoDeContactos;
	}

	public JComboBox<String> getLocalidad() {
		return localidad;
	}

	public void setLocalidad(JComboBox<String> localidad) {
		this.localidad = localidad;
	}

	public void setTipoDeContactos(JComboBox<String> tipoDeContactos) {
		this.tipoDeContactos = tipoDeContactos;
	}

	public JComboBox<String> getMesNacimiento() {
		return jComboBoxMesNacimiento;
	}

	public void setMesNacimiento(JComboBox<String> mesNacimiento) {
		this.jComboBoxMesNacimiento = mesNacimiento;
	}

	public JTextField getPlataformaAlmacenamiento() {
		return txtPlataformaAlmacenamiento;
	}

	public void setPlataformaAlmacenamiento(JTextField plataformaAlmacenamiento) {
		this.txtPlataformaAlmacenamiento = plataformaAlmacenamiento;
	}

	public void setBtnGuardarPersona(JButton btnAgregarPersona) {
		this.btnGuardarPersona = btnAgregarPersona;
	}

	public JButton getBtnGuardarPersona() {
		return btnGuardarPersona;
	}

	public void llenarInfoPersona(PersonaDTO persona, List<TipoDeContactoDTO> tiposDeContacto,
			List<LocalidadDTO> localidades, TipoDeContactoDTO tiposDeContactoDTO, LocalidadDTO localidadDTO) {
		this.txtNombre.setText(persona.getNombre());
		this.txtEmail.setText(persona.getEmail());
		this.txtTelefono.setText(persona.getTelefono());
		this.txtNacimiento.setText(persona.getNacimiento());
		this.txtCalle.setText(persona.getDomicilioDTO().getCalle());
		this.txtAltura.setText(persona.getDomicilioDTO().getAltura());
		this.txtPiso.setText(persona.getDomicilioDTO().getPiso());
		this.txtDepto.setText(persona.getDomicilioDTO().getDepto());
		this.jComboBoxMesNacimiento.setSelectedItem(persona.getMesNacimiento());
		this.txtPlataformaAlmacenamiento.setText(persona.getPlataformaAlmacenamiento());
		this.modelTiposContacto.removeAllElements();
		this.modelLocalidades.removeAllElements();
		llenarTiposDeContacto(tiposDeContacto);
		llenarLocalidades(localidades);
		int indexTipo = this.getModelTipos()
				.getIndexOf(tiposDeContactoDTO.getIdTipoDeContacto() + " - " + tiposDeContactoDTO.getTipoDeContacto());
		int indexLocalidad = this.getModelLocalidades()
				.getIndexOf(localidadDTO.getIdLocalidad() + " - " + localidadDTO.getNombreLocalidad());
		this.getModelTipos().setSelectedItem(this.getModelTipos().getElementAt(indexTipo));
		this.getModelLocalidades().setSelectedItem(this.getModelLocalidades().getElementAt(indexLocalidad));

	}

}