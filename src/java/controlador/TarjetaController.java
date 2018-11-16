package controlador;

import dto.entidad.Tarjeta;
import controlador.util.JsfUtil;
import controlador.util.PaginationHelper;
import dto.dao.TarjetaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("tarjetaController")
@SessionScoped
public class TarjetaController implements Serializable {

    private Tarjeta current;
    private DataModel items = null;
    @EJB
    private dto.dao.TarjetaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public TarjetaController() {
    }

    public Tarjeta getSelected() {
        if (current == null) {
            current = new Tarjeta();
            current.setTarjetaPK(new dto.entidad.TarjetaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private TarjetaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Tarjeta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Tarjeta();
        current.setTarjetaPK(new dto.entidad.TarjetaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getTarjetaPK().setUsuarioidUsuario(current.getUsuario().getIdUsuario());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TarjetaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Tarjeta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getTarjetaPK().setUsuarioidUsuario(current.getUsuario().getIdUsuario());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TarjetaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Tarjeta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TarjetaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Tarjeta getTarjeta(dto.entidad.TarjetaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Tarjeta.class)
    public static class TarjetaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TarjetaController controller = (TarjetaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tarjetaController");
            return controller.getTarjeta(getKey(value));
        }

        dto.entidad.TarjetaPK getKey(String value) {
            dto.entidad.TarjetaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dto.entidad.TarjetaPK();
            key.setIdTarjeta(Integer.parseInt(values[0]));
            key.setUsuarioidUsuario(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(dto.entidad.TarjetaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTarjeta());
            sb.append(SEPARATOR);
            sb.append(value.getUsuarioidUsuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tarjeta) {
                Tarjeta o = (Tarjeta) object;
                return getStringKey(o.getTarjetaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Tarjeta.class.getName());
            }
        }

    }

}
