# Auster
[![Build Status](https://travis-ci.org/Prokky/Auster.svg?branch=master)](https://travis-ci.org/Prokky/Auster)
[![codecov](https://codecov.io/gh/Prokky/Auster/branch/master/graph/badge.svg)](https://codecov.io/gh/Prokky/Auster)
[ ![Download](https://api.bintray.com/packages/prokky/maven/auster/images/download.svg) ](https://bintray.com/prokky/maven/auster/_latestVersion)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Auster-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4021)

Simple lightweight MVP library for Android

##Usage
To include this library to your project add dependency in **build.gradle** file:
```java
dependencies {
    compile 'com.prokkypew:auster:0.9.2'
}
```
### MvpActivity, MvpFragment, MvpView
First create your mvp view interface which extends MvpView and put view callbacks there.
```java
public interface MyMvpView extends MvpView {
    void onLoad(String text);
}
```
Then create your presenter which extends MvpPresenter and put api/data calls there to bind them to your view.
```java
public class MyMvpPresenter extends MvpPresenter<MyMvpView> {
    public MyMvpPresenter() {

    }

    public void loadIp() {
        checkViewAttached();
        getMvpView().setProgress(true);
        // make your ip call, and then use your mvp callback to pass received data to your view.
        IpApi.getApi().getIp().enqueue(new Callback<IpObject>() {
            @Override
            public void onResponse(Call<IpObject> call, Response<IpObject> response) {
                checkViewAttached();
                getMvpView().setProgress(false);
                getMvpView().onIpLoaded(response.body().getText());
            }

            @Override
            public void onFailure(Call<IpObject> call, Throwable t) {
                checkViewAttached();
                getMvpView().setProgress(false);
                getMvpView().onError(0, t.getLocalizedMessage());
            }
        });
    }
}
```

Finally, create your activity which extends MvpActivity, or fragment which extends MvpFragment and implements your MvpView function.
```java
public class MainActivity extends MvpActivity<MainMvpPresenter> implements MainMvpView {
    @Override
    protected MyMvpPresenter getPresenter() {
        return new MyMvpPresenter();
    }
}
```
And make your presenter call where needed:
```java
presenter.loadIp();
```

There is no need to use MvpFragment or MvpActivity, you can just extend MvpView for any view you like.

## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
