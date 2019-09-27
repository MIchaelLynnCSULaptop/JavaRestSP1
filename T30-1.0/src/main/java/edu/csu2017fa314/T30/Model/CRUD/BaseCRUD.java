package edu.csu2017fa314.T30.Model.CRUD;

public abstract class BaseCRUD implements BaseInterfaceCrud {

    public abstract String getAllData();
    public abstract String search(String searchVal);
    public abstract String sort(String searchVal);

}
