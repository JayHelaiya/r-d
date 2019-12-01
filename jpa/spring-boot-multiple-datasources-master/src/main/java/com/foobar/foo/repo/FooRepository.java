package com.foobar.foo.repo;

import java.util.List;

import com.foobar.bar.domain.Bar;
import com.foobar.foo.domain.Foo;

/**
 * @author jayesh.helaiya
 *
 */
public interface FooRepository {

  List<Foo> getfoos();
  List<Bar> getbars();

}
