package com.barclays.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barclays.ams.entity.TransactionDetails;

public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Integer> {

	@Query(value = " select case when sum(amount) is null then 0 else sum(amount) end as total_limit from transaction_details where accno=?1 and date=curdate() ;", nativeQuery = true)
	double findTotalAmountPerDay(long accno);

	@Query(value = "select * from transaction_details where accno=?1 order by cast(concat(date,' ', time) as datetime) desc limit 5;", nativeQuery = true)
	List<TransactionDetails> findLastFiveTransactions(long accno);
}
