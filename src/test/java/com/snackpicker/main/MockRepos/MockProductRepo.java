package com.snackpicker.main.MockRepos;

import com.snackpicker.main.model.Product;
import com.snackpicker.main.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockProductRepo implements ProductRepository {

    private List<Product> productList;

    public MockProductRepo()
    {
        productList = new ArrayList<Product>();
    }

    public void setupDataBase(List<Product> products)
    {
        productList = products;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Product> findAllById(Iterable<Long> longs) {
        List<Product> values = new ArrayList<Product>();

        for(long a : longs)
        {
            try
            {
                for(Product p : productList)
                {
                    if(p.getId() == a) values.add(p);
                }
            }
            catch(Exception e) {}
        }
        return values;
    }

    @Override
    public long count() {
        return productList.size();
    }

    @Override
    public void deleteById(Long aLong) {
        for(int a = 0; a < productList.size(); a++)
        {
            if(aLong == productList.get(a).getId()) productList.remove(a);
        }
    }

    @Override
    public void delete(Product entity) {
        productList.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }

    @Override
    public void deleteAll() {
        productList.clear();
    }

    @Override
    public <S extends Product> S save(S entity) {
        productList.add(entity);
        return  entity;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        for(S s : entities)
        {
            productList.add(s);
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {

        for (Product p : productList)
        {
            if(p.getId() == aLong) return Optional.ofNullable(p);
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Product getOne(Long aLong) {
        return null;
    }

    @Override
    public Product getById(Long aLong) {
        return null;
    }

    @Override
    public Product getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
