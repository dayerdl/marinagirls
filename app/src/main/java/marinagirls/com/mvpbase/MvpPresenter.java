package marinagirls.com.mvpbase;

/**
 * Created by David on 1/18/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}

