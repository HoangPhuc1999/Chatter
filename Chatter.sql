USE [chatter]
GO
/****** Object:  Table [dbo].[banks_info]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[banks_info](
	[bank_id] [int] IDENTITY(1,1) NOT NULL,
	[bank_name] [varchar](255) NOT NULL,
	[bank_code] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[bank_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[coupons]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[coupons](
	[coupon_code] [varchar](255) NOT NULL,
	[product_discount_id] [int] NULL,
	[discount_amount] [int] NOT NULL,
	[expire_date] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[coupon_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[deleted_messages]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[deleted_messages](
	[messages_id] [int] NOT NULL,
	[message_content] [nvarchar](max) NOT NULL,
	[message_type] [char](100) NOT NULL,
	[deleted_at] [datetime] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[groups]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[groups](
	[group_id] [int] IDENTITY(1,1) NOT NULL,
	[groupname] [varchar](50) NOT NULL,
	[users_id] [int] NOT NULL,
	[avatar] [char](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messages]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messages](
	[messages_id] [int] IDENTITY(1,1) NOT NULL,
	[sender] [int] NOT NULL,
	[receiver] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[messages_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messages_content]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messages_content](
	[messages_id] [int] NOT NULL,
	[message_content] [nvarchar](max) NOT NULL,
	[message_type] [char](100) NOT NULL,
	[created_at] [datetime] NULL,
	[seen] [bit] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[order_by] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders_details]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders_details](
	[order_id] [int] NULL,
	[order_product_id] [int] NULL,
	[order_amount] [int] NOT NULL,
	[order_date] [datetime] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_name] [varchar](255) NOT NULL,
	[product_price] [float] NOT NULL,
	[product_title] [varchar](255) NOT NULL,
	[product_description] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products_category]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products_category](
	[product_id] [int] NOT NULL,
	[category_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products_image]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products_image](
	[product_id] [int] NULL,
	[product_image_path] [varchar](max) NOT NULL,
	[modified_at] [datetime] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products_inventory]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products_inventory](
	[product_id] [int] NULL,
	[product_quantity] [int] NOT NULL,
	[modified_at] [datetime] NULL,
	[created_at] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products_review]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products_review](
	[review_id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NOT NULL,
	[title] [varchar](255) NOT NULL,
	[review_content] [varchar](255) NOT NULL,
	[rating] [varchar](255) NOT NULL,
	[review_image_path] [varchar](255) NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[review_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[users_id] [int] IDENTITY(1,1) NOT NULL,
	[firstname] [varchar](50) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[gender] [bit] NOT NULL,
	[avatar] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[users_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_account]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_account](
	[users_id] [int] NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_address]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_address](
	[users_id] [int] NULL,
	[home_address] [varchar](50) NOT NULL,
	[district] [varchar](50) NOT NULL,
	[city] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_cart]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_cart](
	[users_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[order_amount] [int] NOT NULL,
	[created_at] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_friends]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_friends](
	[users_id] [int] NULL,
	[friend_id] [int] NULL,
	[date_modified] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_payment]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_payment](
	[users_id] [int] NOT NULL,
	[bank_id] [int] NOT NULL,
	[account_number] [varchar](50) NOT NULL,
	[expiry_date] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_role]    Script Date: 5/29/2022 9:50:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_role](
	[users_id] [int] NOT NULL,
	[user_role] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[banks_info] ON 

INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (1, N'Ngân hàng Nông nghi?p và Phát tri?n Nông thôn VN', N'Agribank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (2, N'Ngân hàng Xây d?ng', N'CB')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (3, N'Ngân hàng Ð?i Duong', N'OceanBank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (4, N'Ngân hàng D?u Khí Toàn C?u', N'GPBank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (5, N'Ngân hàng Ð?u tu và Phát tri?n Vi?t Nam', N'BIDV')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (6, N'Ngân hàng Công Thuong Vi?t Nam ', N'Viettinbank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (7, N'Ngân hàng Ngo?i Thuong Vi?t Nam', N'Vietcombank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (8, N'Ngân hàng Vi?t Nam Th?nh Vu?ng', N'VP Bank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (9, N'Ngân hàng Quân Ð?i', N'MB')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (10, N'Ngân hàng Tiên Phong', N'TP Bank')
INSERT [dbo].[banks_info] ([bank_id], [bank_name], [bank_code]) VALUES (11, N'Ngân hàng K? Thuong Vi?t Nam', N'Techcombank')
SET IDENTITY_INSERT [dbo].[banks_info] OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([category_id], [category_name]) VALUES (1, N'foods')
INSERT [dbo].[category] ([category_id], [category_name]) VALUES (2, N'drinks')
INSERT [dbo].[category] ([category_id], [category_name]) VALUES (3, N'hats')
INSERT [dbo].[category] ([category_id], [category_name]) VALUES (4, N'Combo')
INSERT [dbo].[category] ([category_id], [category_name]) VALUES (5, N'Ice Cream')
INSERT [dbo].[category] ([category_id], [category_name]) VALUES (6, N'Group Set')
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (1, N'Chicken Hamburger', 5, N'Hamburger title', N'Hamburger des')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (2, N'Burger Mozzarella', 4.9, N'Burger Mozzarella', N'Burger with Mozzarella cheese')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (3, N'Burger Double Double', 5.1, N'Burger Double Double', N'Burger with double beef, double cheese, onion, tomato')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (4, N'Shrimp Burger', 5.2, N'Shrimp Burger', N'Burger with shrimp, mayonnaise')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (5, N'Burger Bulgogi', 6.1, N'Burger Bulgogi', N'Burger Bulgogi include beef , onion, mayonnaise and bulgogi sauce')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (6, N'Beef Teriyaki egg Burger', 5.5, N'Beef Teriyaki egg Burger', N'Beef Teriyaki egg Burger include beef teriyaki, egg, onion, tomato,mayonnaise ')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (7, N'Grilled chicken - 1 piece', 2.1, N'Grilled chicken - 1 piece', N'grilled chicken - 1 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (8, N'grilled chicken - 9 piece', 16.9, N'grilled chicken - 9 piece', N'grilled chicken - 9 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (9, N'Chicken With H&S Sauce - 1 piece', 2.1, N'Chicken With H&S Sauce - 1 piece', N'Chicken With H&S Sauce - 1 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (10, N'Chicken With H&S Sauce - 9 piece', 17.5, N'Chicken With H&S Sauce - 9 piece', N'Chicken With H&S Sauce - 9 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (11, N'Chicken With Cheese Sauce - 1 Pieces', 2.3, N'Chicken With Cheese Sauce - 1 Pieces', N'Chicken With Cheese Sauce - 1 Pieces')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (12, N'Chicken With Cheese Sauce - 9 Pieces', 17.9, N'Chicken With Cheese Sauce - 9 Pieces', N'Chicken With Cheese Sauce - 9 Pieces')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (13, N'Original fried chicken - 1 piece', 1.9, N'Original fried chicken - 1 piece', N'Original fried chicken - 1 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (14, N'Original fried chicken - 9 piece', 16.5, N'Original fried chicken - 9 piece', N'Original fried chicken - 9 piece')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (15, N'Grilled chicken rice', 2.7, N'Grilled chicken rice', N'Grilled chicken rice include : Rice, griilled chicken, tomatom salad')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (16, N'Bean Sauce Chicken Rice', 2.7, N'Bean Sauce Chicken Rice', N'Bean Sauce Chicken Rice : Rice, Bean Sauce Chicken, tomatom salad')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (17, N'Chicken Ball Rice', 2.7, N'Chicken Ball Rice', N'Chicken Ball Rice include : Rice, Chicken Ball, tomatom salad')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (18, N'Beef rice', 2.7, N'Beef rice', N'Beef rice include : Rice, beef, tomatom salad')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (19, N'Cheese Beef Rice', 2.7, N'Cheese Beef Rice', N'Cheese Beef Rice include : Rice, Beef, tomatom ,salad, cheesse')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (20, N'Beef Spaghetti', 2.7, N'Beef Spaghetti', N'Beef Spaghetti include : noodle, beef, tomatom salad')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (21, N'Chicken soup', 0.9, N'Chicken soup', N'Chicken soup')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (22, N'Chicken Skewers - 2 Skewers', 2.2, N'Chicken Skewers - 2 Skewers', N'Chicken Skewers - 2 Skewers')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (23, N'Shake Chicken with cheese powder', 2.5, N'Shake Chicken with cheese powder', N'Shake Chicken with cheese powder')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (24, N'Cheese sticks', 1.3, N'Cheese sticks', N'Cheese sticks')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (25, N'Fish Nugget - 5 Pieces', 1.7, N'Fish Nugget - 5 Pieces', N'Fish Nugget - 5 Pieces')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (26, N'Fried Squid - 5 Pieces', 1.7, N'Fried Squid - 5 Pieces', N'Fried Squid - 5 Pieces')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (27, N'French Fries (M)', 1.3, N'French Fries (M)', N'French Fries (M)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (28, N'French Fries (L)', 1.9, N'French Fries (L)', N'French Fries (M)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (29, N'Orange juice', 1, N'Orange juice', N'Orange juice')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (30, N'7Up Coconut Pineapple', 1.2, N'7Up Coconut Pineapple', N'7Up Coconut Pineapple')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (31, N'7Up Melon Peach', 1.2, N'7Up Melon Peach', N'7Up Melon Peach')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (32, N'Milo', 0.9, N'Milo', N'Milo')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (33, N'7 UP (L)', 0.9, N'7 UP (L)', N'7 UP (L)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (34, N'Pepsi (L)', 0.9, N'Pepsi (L)', N'Pepsi (L)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (35, N'Mirinda (L)', 0.9, N'Mirinda (L)', N'Mirinda (L)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (36, N'Nestea', 0.9, N'Nestea', N'Nestea')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (37, N'Tornado Cashew', 1.7, N'Tornado Cashew', N'Tornado Cashew')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (38, N'Tornado Chocolate', 1.7, N'Tornado Chocolate', N'Tornado Chocolate')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (39, N'Tornado Coconut Pineapple', 1.8, N'Tornado Coconut Pineapple', N'Tornado Coconut Pineapple')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (40, N'Tornado Melon Peach', 1.7, N'Tornado Melon Peach', N'Tornado Melon Peach')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (41, N'Combo Burger Mozzarella', 5.3, N'Combo Burger Mozzarella', N'Combo Burger Mozzarella : 1 Burger Mozzarella + 1 pepsi (M) + 1 French fries')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (42, N'Combo Burger Double Double', 5.7, N'Combo Burger Double Double', N'Combo Burger Double Double : 1 Burger Double Double + 1 pepsi (M) + 1 French fries')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (43, N'Combo Shrimp Burger ', 5.5, N'Combo Shrimp Burger', N'Combo Shrimp Burger : 1 Shrimp Burger + 1 pepsi (M) + 1 French fries')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (44, N'Cheese Burger Combo', 5.9, N'Cheese Burger Combo', N'Cheese Burger Combo : 1 Cheese Burger Combo + 1 pepsi (M) + 1 French fries')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (45, N'Loking Set (Save $ 3.1)', 12.1, N' Loking Set', N'Loking Set : - 04 origin fried chicken + 01 Burger Bulgogi + 01 Shrimp Burger + 01 Potato shake + 04 Pepsi (M)')
INSERT [dbo].[products] ([product_id], [product_name], [product_price], [product_title], [product_description]) VALUES (46, N'Lody Set', 10.5, N'Lody Set', N'Lody Set: 03 Fried Chicken + 01 Spaghetti + 01 Shake Chicken + 01 Shake Potato + 03 Pepsi (M)')
SET IDENTITY_INSERT [dbo].[products] OFF
GO
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (1, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (2, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (3, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (4, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (33, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (34, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (35, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (36, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (37, 5)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (38, 5)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (39, 5)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (40, 5)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (41, 4)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (42, 4)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (43, 4)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (44, 4)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (45, 6)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (46, 6)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (5, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (6, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (7, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (8, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (9, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (10, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (11, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (12, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (13, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (14, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (15, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (16, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (17, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (18, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (19, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (20, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (21, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (22, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (23, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (24, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (25, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (26, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (27, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (28, 1)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (29, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (30, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (31, 2)
INSERT [dbo].[products_category] ([product_id], [category_id]) VALUES (32, 2)
GO
INSERT [dbo].[products_image] ([product_id], [product_image_path], [modified_at]) VALUES (1, N'https://images.foody.vn/res/g93/923143/prof/s640x400/foody-upload-api-foody-mobile-hmc-190528141210.jpg', CAST(N'2022-05-25T22:51:21.903' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([users_id], [firstname], [lastname], [email], [gender], [avatar]) VALUES (1, N'mark', N'kass', N'user1@fpt.edu.vn', 0, N'images/girl.jpg')
INSERT [dbo].[users] ([users_id], [firstname], [lastname], [email], [gender], [avatar]) VALUES (2, N'john', N'viet', N'user2@fpt.edu.vn', 1, N'images/boy.jpg')
INSERT [dbo].[users] ([users_id], [firstname], [lastname], [email], [gender], [avatar]) VALUES (3, N'gary', N'bass', N'user3@fpt.edu.vn', 1, N'images/boy.jpg')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
INSERT [dbo].[users_account] ([users_id], [username], [password]) VALUES (1, N'user1', N'user1')
INSERT [dbo].[users_account] ([users_id], [username], [password]) VALUES (2, N'user2', N'user2')
INSERT [dbo].[users_account] ([users_id], [username], [password]) VALUES (3, N'user3', N'user3')
GO
INSERT [dbo].[users_address] ([users_id], [home_address], [district], [city]) VALUES (1, N'12 hang bai', N'Hoan Kiem', N'Hanoi')
INSERT [dbo].[users_address] ([users_id], [home_address], [district], [city]) VALUES (2, N'55 Nguyen Hoang Ton', N'Bac Tu Liem', N'Hanoi')
INSERT [dbo].[users_address] ([users_id], [home_address], [district], [city]) VALUES (3, N'2 Nguyen Trai', N'Quan 1', N'Ho Chi Minh city')
GO
INSERT [dbo].[users_role] ([users_id], [user_role]) VALUES (1, N'user')
INSERT [dbo].[users_role] ([users_id], [user_role]) VALUES (2, N'seller')
INSERT [dbo].[users_role] ([users_id], [user_role]) VALUES (3, N'seller')
GO
ALTER TABLE [dbo].[deleted_messages] ADD  DEFAULT (getdate()) FOR [deleted_at]
GO
ALTER TABLE [dbo].[messages_content] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[orders_details] ADD  DEFAULT (getdate()) FOR [order_date]
GO
ALTER TABLE [dbo].[products_image] ADD  DEFAULT (getdate()) FOR [modified_at]
GO
ALTER TABLE [dbo].[products_inventory] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[products_review] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[users_cart] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[users_friends] ADD  DEFAULT (getdate()) FOR [date_modified]
GO
ALTER TABLE [dbo].[coupons]  WITH CHECK ADD FOREIGN KEY([product_discount_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[deleted_messages]  WITH CHECK ADD FOREIGN KEY([messages_id])
REFERENCES [dbo].[messages] ([messages_id])
GO
ALTER TABLE [dbo].[groups]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD FOREIGN KEY([receiver])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD FOREIGN KEY([sender])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[messages_content]  WITH CHECK ADD FOREIGN KEY([messages_id])
REFERENCES [dbo].[messages] ([messages_id])
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD FOREIGN KEY([order_by])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[orders_details]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[orders_details]  WITH CHECK ADD FOREIGN KEY([order_product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[products_category]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([category_id])
GO
ALTER TABLE [dbo].[products_category]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[products_image]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[products_inventory]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[products_review]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[users_account]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_address]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_cart]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[users_cart]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_friends]  WITH CHECK ADD FOREIGN KEY([friend_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_friends]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_payment]  WITH CHECK ADD FOREIGN KEY([bank_id])
REFERENCES [dbo].[banks_info] ([bank_id])
GO
ALTER TABLE [dbo].[users_payment]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
ALTER TABLE [dbo].[users_role]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
GO
