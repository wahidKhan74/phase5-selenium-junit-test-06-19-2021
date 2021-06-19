package com.ecom.webapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardJunitAnnotations {

		@BeforeAll
		static void setUpBeforeAll() {
			System.out.println(" Before All Test");
		}
		
		@AfterAll
		static void tearDownAfterAll() {
			System.out.println(" After All Test");
		}
		
		@BeforeEach
		void setUp() {
			System.out.println(" Before Each Test");
		}
	
		@AfterEach
		void tearDown() {
			System.out.println(" After Each Test");
		}
		
		@Test
		public void testOne(){
			System.out.println("--- Test One ---");
		}
		
		@Test
		public void testTwo(){
			System.out.println("--- Test Two ---");
		}
		
		@Test
		public void testThree(){
			System.out.println("--- Test Three ---");
		}
}
