package com.home.prospring.repostory;

import com.home.prospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);  //@Id로 돼있어서 (PK)
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)   //Member Entity에 query 하는것, m = as m
                .getResultList();
    }

    @Override
    public Long check(String name) {
        Long cnt = (Long)em.createNativeQuery("select count(m) from Member m where m.name = :name ", Member.class).getSingleResult();
        return cnt;
    }


}
