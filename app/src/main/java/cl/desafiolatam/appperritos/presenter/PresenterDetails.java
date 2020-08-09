package cl.desafiolatam.appperritos.presenter;

import cl.desafiolatam.appperritos.model.IModel;

public class PresenterDetails implements IPresenterDetails, IPresenterViewDetails {
    IPresenterViewDetails iPresenterViewDetail;
    IModel imodel;

    public PresenterDetails(IPresenterViewDetails iPresenterViewDetail) {
        this.iPresenterViewDetail = iPresenterViewDetail;
    }

    public void setImodel(IModel imodel) {
        this.imodel = imodel;
    }

    @Override
    public void loadBreedImages(String breed) {
        imodel.loadImages(breed);

    }

    @Override
    public void loadSubBreedImages(String breed, String subBreed) {
        imodel.loadImages(breed);

    }

    @Override
    public void showBreedImages(String breed) {
        iPresenterViewDetail.showBreedImages(breed);

    }
}
