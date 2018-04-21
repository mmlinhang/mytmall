USE mytmalldb;

ALTER TABLE t_product
  ALTER stock SET DEFAULT 0;

ALTER TABLE t_product
  ALTER review_num SET DEFAULT 0;

ALTER TABLE t_product
  ALTER vol SET DEFAULT 0;

ALTER TABLE t_product
  ADD createDate DATE NOT NULL;