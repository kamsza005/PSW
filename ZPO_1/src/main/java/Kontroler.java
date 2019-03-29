import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;

public class Kontroler {
    public TableView<Employee> fEmp;
    public TableColumn<Employee, Integer> fid;
    public TableColumn<Employee, String> fname;
    public TableColumn<Employee, String> femail;
    public TableColumn<Employee, String> fsal;
    public TableColumn<Employee,Void> act;
    public Button news;
    EmplyeeDAOimpl edi = new EmplyeeDAOimpl();
    public void initialize() {
        fEmp.setEditable(true);
        act.setMinWidth(40);
        news.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Employee myItem = new Employee();
                fEmp.getItems().add(myItem);
            }
            });
        edit();
        fid.setCellFactory(TextFieldTableCell.<Employee,Integer>forTableColumn(new IntegerStringConverter()));
        fname.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        femail.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        fsal.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        fid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        femail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        fsal.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        fEmp.setItems((ObservableList) edi.findAll());
        addButtonToTable();

    }

    private void addButtonToTable() {
        act.setCellFactory(param -> new TableCell<Employee, Void>() {
            private final Button editButton = new Button("Apply");
            private final Button deleteButton = new Button("Delete");
            private final HBox pane = new HBox(deleteButton, editButton);

            {
                deleteButton.setOnAction(event -> {
                    Employee getEmp = getTableView().getItems().get(getIndex());
                    edi.delete(getEmp);
                    getTableView().getItems().remove(getEmp);
                    System.out.println(getEmp.getId() + "   " + getEmp.getName());
                });

                editButton.setOnAction(event -> {
                    Employee getEmp2 = getTableView().getItems().get(getIndex());
                    edi.save(getEmp2);
                });
            }

            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                setGraphic(empty ? null : pane);
            }
        });

    }
    public void edit(){
        fid.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>() {
                    public void handle(TableColumn.CellEditEvent<Employee, Integer> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setId(t.getNewValue());
                    }
                }
        );
        fname.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );
        femail.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                    }
                }
        );
        fsal.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSalary(t.getNewValue());
                    }
                }
        );
    }
}


