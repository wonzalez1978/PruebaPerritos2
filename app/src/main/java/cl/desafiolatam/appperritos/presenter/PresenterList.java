package cl.desafiolatam.appperritos.presenter;

import java.util.List;

import cl.desafiolatam.appperritos.model.IModel;

public class PresenterList implements IPresenterList, IPresenterModel {


    IPresenterViewList iPresenterViewList;
    IModel imodel;

    public PresenterList(IPresenterViewList iPresenterViewList) {
        this.iPresenterViewList = iPresenterViewList;
    }

    public void setImodel(IModel imodel) {
        this.imodel = imodel;
    }

    @Override
    public void loadBreeds() {
        imodel.loadBreeds();

    }

    @Override
    public void notificar(List<String> breeds) {
        iPresenterViewList.notificar(breeds);

    }

    public interface IPresenterViewList {
        void notificar(List<String> breeds);
    }
}
