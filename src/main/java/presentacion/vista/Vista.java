package presentacion.vista;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import persistencia.conexion.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Vista {
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporteMesNacimiento;
	private JButton btnReportePlataformaAlmacenamiento;
	private JButton btnEditar;
	private JButton btnVerAgenda;
	private JButton btnVerTipoDeContacto;
	private JComboBox<String> jComboBoxSort;
	private JButton btnLocalidades;
	private JScrollPane spPersonas;
	private JLabel lblOrden;
	private int vistaSeleccionada;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnasPersona = { "Nombre y apellido", "Telefono", "Email", "Nacimiento",
			"Tipo de Contacto", "Localidad", "MesNacimiento", "Plataforma Almacenamiento" };
	private String[] nombreColumnasTipoDeContacto = { "Tipo de Contacto" };
	private String[] nombreColumnasLocalidades = { "Localidad", "Provincia", "Pais" };

	public Vista() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1104, 394);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 859, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(java.awt.Color.GRAY);

		spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 842, 290);
		panel.add(spPersonas);

		cargarTablaPersonas();
		vistaSeleccionada = 1;

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(897, 11, 175, 152);
		frame.getContentPane().add(panel_1);

		btnVerAgenda = new JButton("Ver Agenda");
		btnVerAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerAgenda.setBounds(823, 25, 75, 302);
		panel_1.add(btnVerAgenda);

		String verTipoContact = "Ver Tipos de Contacto";
		btnVerTipoDeContacto = new JButton(verTipoContact);
		btnVerTipoDeContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnVerTipoDeContacto);

		btnLocalidades = new JButton("Ver Localidades");
		btnLocalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnLocalidades);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 308, 851, 33);
		frame.getContentPane().add(panel_2);

		btnAgregar = new JButton("Agregar Persona");
		panel_2.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnEditar = new JButton("Editar Persona");
		panel_2.add(btnEditar);

		btnBorrar = new JButton("Borrar Persona");
		panel_2.add(btnBorrar);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(867, 247, 221, 97);
		frame.getContentPane().add(panel_1_1);

		lblOrden = new JLabel("Orden:");
		panel_1_1.add(lblOrden);

		jComboBoxSort = new JComboBox<>();
		jComboBoxSort.setBounds(850, 258, 95, 23);
		panel_1_1.add(jComboBoxSort);

		this.jComboBoxSort.addItem("Descendente");
		this.jComboBoxSort.addItem("Ascendente");

		btnReporteMesNacimiento = new JButton("Reporte Mes Nacimiento");
		panel_1_1.add(btnReporteMesNacimiento);

		btnReportePlataformaAlmacenamiento = new JButton("Reporte Plat. Almacenamiento");
		panel_1_1.add(btnReportePlataformaAlmacenamiento);

	}

	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(
						null, "¿Estás seguro que quieres salir de la Agenda?",
						"Confirmación", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	public JButton getBtnVerAgenda() {
		return btnVerAgenda;
	}

	public void setBtnVerAgenda(JButton btnVerAgenda) {
		this.btnVerAgenda = btnVerAgenda;
	}

	public JButton getBtnVerTipoDeContacto() {
		return btnVerTipoDeContacto;
	}

	public void setBtnVerTipoDeContacto(JButton btnVerTipoDeContacto) {
		this.btnVerTipoDeContacto = btnVerTipoDeContacto;
	}

	public JButton getBtnLocalidades() {
		return btnLocalidades;
	}

	public void setBtnLocalidades(JButton btnLocalidades) {
		this.btnLocalidades = btnLocalidades;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnReporteMesNacimiento() {
		return btnReporteMesNacimiento;
	}

	public JButton getBtnReportePlataformaAlmacenamiento() {
		return btnReportePlataformaAlmacenamiento;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public String[] getNombreColumnasPersona() {
		return nombreColumnasPersona;
	}

	public String[] getNombreColumnasTipoDeContacto() {
		return nombreColumnasTipoDeContacto;
	}

	public void setNombreColumnasTipoDeContacto(String[] nombreColumnasTipoDeContacto) {
		this.nombreColumnasTipoDeContacto = nombreColumnasTipoDeContacto;
	}

	public String[] getNombreColumnasLocalidades() {
		return nombreColumnasLocalidades;
	}

	public void setNombreColumnasLocalidades(String[] nombreColumnasLocalidades) {
		this.nombreColumnasLocalidades = nombreColumnasLocalidades;
	}

	public int getVistaSeleccionada() {
		return vistaSeleccionada;
	}

	public void setVistaSeleccionada(int vistaSeleccionada) {
		this.vistaSeleccionada = vistaSeleccionada;
	}

	public JLabel getLblOrden() {
		return lblOrden;
	}

	public void setLblOrden(JLabel lblOrden) {
		this.lblOrden = lblOrden;
	}

	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnasPersona());

		for (PersonaDTO p : personasEnTabla) {
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String email = p.getEmail();
			String fecha = p.getNacimiento();
			String tipoContacto = p.getTipoContacto();
			String localidad = p.getLocalidad().getNombreLocalidad();
			String mesNacimiento = p.getMesNacimiento();
			String plataformaNacimiento = p.getPlataformaAlmacenamiento();
			Object[] fila = { nombre, tel, email, fecha, tipoContacto, localidad,
					mesNacimiento,
					plataformaNacimiento };
			this.getModelPersonas().addRow(fila);
		}
	}

	public void llenarTablaLocalidades(List<LocalidadDTO> localidadesEnTabla) {
		this.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnasLocalidades());

		for (LocalidadDTO l : localidadesEnTabla) {
			String localidad = l.getNombreLocalidad();
			String provincia = l.getProvincia();
			String pais = l.getPais();
			Object[] fila = { localidad, provincia, pais };
			this.getModelPersonas().addRow(fila);
		}
	}

	public void llenarTablaTiposDeContacto(List<TipoDeContactoDTO> tipoDeContactoEnTabla) {
		this.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnasTipoDeContacto());

		for (TipoDeContactoDTO t : tipoDeContactoEnTabla) {
			String tipoDeContacto = t.getTipoDeContacto();
			Object[] fila = { tipoDeContacto };
			this.getModelPersonas().addRow(fila);
		}
	}

	public void cargarTablaPersonas() {
		modelPersonas = new DefaultTableModel(null, nombreColumnasPersona);
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
	}

	public void cargarTablaLocalidades() {
		modelPersonas = new DefaultTableModel(null, nombreColumnasLocalidades);
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
	}

	public void cargarTablaTipodeContacto() {
		modelPersonas = new DefaultTableModel(null, nombreColumnasTipoDeContacto);
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
	}

	public void cargarVistaLocalidad() {
		getBtnAgregar().setText("Agregar Localidad");
		getBtnEditar().setText("Editar Localidad");
		getBtnBorrar().setText("Borrar Localidad");
		getBtnAgregar().setBounds(20, 312, 200, 23);
		getBtnBorrar().setBounds(540, 312, 200, 23);
	}

	public void cargarVistaTipoContacto() {
		getBtnAgregar().setText("Agregar Tipo de Contacto");
		getBtnEditar().setText("Editar Tipo de Contacto");
		getBtnBorrar().setText("Borrar Tipo de Contacto");
		getBtnAgregar().setBounds(20, 312, 200, 23);
		getBtnEditar().setBounds(280, 312, 200, 23);
		getBtnBorrar().setBounds(540, 312, 200, 23);
	}

	public void cargarVistaPersona() {
		getBtnAgregar().setText("Agregar Persona");
		getBtnEditar().setText("Editar Persona");
		getBtnBorrar().setText("Borrar Persona");
		getBtnAgregar().setBounds(20, 312, 175, 23);
		getBtnEditar().setBounds(220, 312, 175, 23);
		getBtnBorrar().setBounds(420, 312, 175, 23);
	}

	public JComboBox<String> getComboSort() {
		return jComboBoxSort;
	}
}
