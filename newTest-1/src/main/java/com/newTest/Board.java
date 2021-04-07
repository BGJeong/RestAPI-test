package com.newTest;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="board_seq")
	@SequenceGenerator(sequenceName="sequence_board", allocationSize=1, name="board_seq")
	private Long bid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="content")
	private String content;
	
	@Column(name="nowdate")
	private String nowDate;
}
