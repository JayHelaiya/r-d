package com.foobar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.bar.domain.Bar;
import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;

@RestController
public class FooBarController {

  private final FooRepository fooRepo;

  @Autowired
  FooBarController(FooRepository fooRepo) {
    this.fooRepo = fooRepo;
  }

  @RequestMapping("/foobar/foos")
  public List<Foo> fooBars() {
    return fooRepo.getfoos();
  }
  
  @RequestMapping("/foobar/bars")
  public List<Bar> bars() {
    return fooRepo.getbars();
  }
}
