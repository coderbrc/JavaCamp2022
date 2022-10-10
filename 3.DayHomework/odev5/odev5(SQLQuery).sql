--Select
Select * from Customers
Select ContactName Adı,CompanyName [Şirket Adı],City Şehir from Customers
Select * from Customers where City='London'
Select *from Products where CategoryId=1 or CategoryId=3
Select *from Products where CategoryId=1 and UnitPrice>=10
Select * from Products order by ProductName
Select * from Products order by CategoryId,ProductName
Select * from Products where CategoryId=1 order by UnitPrice desc
Select count(*) ÜrünSayısı from Products
Select count(*) ÜrünSayısı from Products where CategoryId=2
Select CategoryId ,count(*) from Products group by CategoryId
Select CategoryId, count(*) from Products where UnitPrice>20 group by CategoryId having count(*)<10

Select Products.ProductID,Products.ProductName,Products.UnitPrice,Categories.CategoryName 
from Products inner join Categories 
on Products.CategoryID=Categories.CategoryID
where UnitPrice>10
Select * from Products p inner join [Order Details] od on p.ProductID=od.ProductID
Select *from Customers c left join Orders o on c.CustomerID=o.CustomerID where o.CustomerID is null