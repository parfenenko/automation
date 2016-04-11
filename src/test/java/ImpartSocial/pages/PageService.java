package ImpartSocial.pages;

import framework.BaseTest;

/**
 * Created by j.parfenenko on 3/27/16.
 */
public class PageService extends BaseTest {

    public CmsLoginPage openCmsLoginPage(String Url){
        openPage(Url);
        return new CmsLoginPage();
    }
}
