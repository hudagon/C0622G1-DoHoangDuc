
-- ADDING DATA INTO THE DTB -- 

-- User Type --

INSERT INTO `user_type` VALUES (1,1,'Diamond'),(2,1,'Platinum'),(3,1,'Gold'),(4,1,'Silver'),(5,1,'Bronze'),(6,1,'Member');

-- Account --

INSERT INTO `account` 
VALUES (1,1,1,'$2a$10$INQPgNIllUy/YZlakoMEqu1e7.FGHivmfM.KbFA0WpoV3pEU2GTQO','ducdh'),
(2,1,1,'$2a$10$INQPgNIllUy/YZlakoMEqu1e7.FGHivmfM.KbFA0WpoV3pEU2GTQO','randomguy'),
(3,1,1,'$2a$10$INQPgNIllUy/YZlakoMEqu1e7.FGHivmfM.KbFA0WpoV3pEU2GTQO','nhicute');

-- role `admin` --
   -- username: ducdh --
   -- password: 123456 --

-- role `user` --
   -- username: randomguy --
   -- password: 123456 --
   
-- Role -- 

INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

-- Account Role --

INSERT INTO `account_role` VALUES (1,1,1),(2,1,2),(3,2,2),(4,3,1),(5,3,2);

-- User --

INSERT INTO `dtb_demo`.`user` (`id`, `avatar`, `birthday`, `delete_status`, `email`, `first_name`, `id_card`, `last_name`, `phone`, `account_id`, `user_type_id`) VALUES ('1', 'https://news.artnet.com/app/news-upload/2019/01/Cat-Photog-Feat-256x256.jpg', '2000-11-01', '0', 'amthanhloama@gmail.com', 'Đỗ', '206395960', 'Hoàng Đức', '0766011120', '1', '1');

-- Address --

INSERT INTO `hudagon_music`.`address` (`address_detail`, `city`, `country`, `delete_status`, `district`, `town`, `user_id`) VALUES ('51 Anh Thơ', 'Đà Nẵng', 'Việt Nam', '1', 'Ngũ Hành Sơn', 'Khuê Mỹ', '1');

-- Category --

INSERT INTO `category` VALUES (1,1,'Electronic Guitar'),(2,1,'Acoustic Guitar'),(3,1,'Electronic Piano'),(4,1,'Acoustic Piano');

-- Brand --

INSERT INTO `brand` 
VALUES (1,'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Fender_guitars_logo.svg/2560px-Fender_guitars_logo.svg.png','1','Fender','United States'),
(2,'https://logos-world.net/wp-content/uploads/2020/12/Ibanez-Logo.png','1','Ibanez','Japan'),
(3,'https://upload.wikimedia.org/wikipedia/commons/2/2d/Martin_guitar_logo.png','1','Martin','United States'),
(4,'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Ephipone_guitars_logo.svg/2560px-Ephipone_guitars_logo.svg.png','1','Epiphone','Greece'),
(5,'https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Gibson_Guitar_logo.svg/1280px-Gibson_Guitar_logo.svg.png','1','Gibson','United States'),
(6,'https://images-scms.s3.amazonaws.com/wp-content/uploads/2020/08/Nord-Logo-534x42338-1.jpg','1','Nord','Sweden'),
(7,'https://w7.pngwing.com/pngs/176/210/png-transparent-yamaha-corporation-musical-instruments-piano-logo-clavinova-musical-instruments-text-piano-digital-piano.png','1','Yamaha','Japan');

-- Product--

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Ngày nay, guitar không cần phải đắt tiền mới sở hữu được âm thanh hay, phần lớn là nhờ vào các nhà sản xuất luôn đi đầu xu hướng như Ibanez. Dựa trên dòng RG đình đám, GIO series đã được phát triển dành cho người chơi muốn chất lượng Ibanez trứ danh với mức giá hết sức hạt dẻ. Không chỉ mang vẻ ngoài và tính năng chơi tốt hơn các dòng khác cùng tầm giá, mà sự kiểm duyệt gắt gao, cơ cấu và dịch vụ bảo hành cũng hoàn toàn như các model đắt tiền khác của Ibanez. Với mức giá phù hợp, dòng guitar này là lối dẫn hoàn hảo đưa bạn tới nấc thang sở hữu Ibanez. GRX70QA sở hữu Powersound pickups theo bố cục H-S-H.', '4840000', '20', '2023-01-31', '2', '1', 'Ibanez Gio GRX70QA-TBB Electric Guitar, Transparent Blue Burst');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Thiết kế phong cách của 40 Series đã thêm vào giai điệu chất âm xưa cũ cổ điển, mặt lưng và hông bằng gỗ East Indian Rosewood, mặt top bằng gỗ Sitka spruce với hệ thống bracing kiểu X và neck joint vừa vặn. Bộ khoá open-gear, binding antique white với finish bóng bẩy, pickguard tortoise và inlay abalone pearl cho vẻ ngoài bắt mắt và âm sắc “mẫu mực”. Cần đàn dài, low-oval đã được tinh chỉnh với tapper nông hơn, hỗ trợ chơi kỹ thuật strumming và picking hàng giờ liền một cách thoải mái và nhiều niềm vui.', '170060000', '20', '2022-12-23', '3', '2', 'Martin Standard Series OM-42 Acoustic Guitar w/Case');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Với danh tiếng và lượng người hâm mộ ngày càng đông đảo, Martin đã hợp tác với John Mayer để sáng tạo nên một cây guitar cùng tên thứ hai, một cây guitar có nhiều đặc điểm giống với cây OM-28JM Limited Edition đầu tiên của Mayer, nhưng cây guitar này sẽ có giá phải chăng hơn và phổ biến hơn với model Martin 000-28EC Eric Clapton rất được yêu thích. Cây guitar Orchestra Model trang nhã này thể hiện tính linh hoạt của mình trong cách phong cách âm nhạc đương đại, đa dạng ngày nay.', '106260000', '20', '2022-01-13', '3', '2', 'Martin John Mayer Signature OMJM Acoustic Guitar w/Case');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Chỉ có bầu trời có thể giới hạn khả năng di chuyển! Đàn guitar du lịch Backpaker dây thép rất nhẹ, bền, dễ chơi (và dễ điều chỉnh) với dáng đàn đặt vừa vặn vào những nơi nhỏ hẹp nhất. Được chế tác từ gỗ tonewood chắc chắn, mẫu guitar này có các bộ phận làm từ GỖ BỀN VỮNG ĐƯỢC CHỨNG NHẬN.  ', '8030000', '20', '2022-04-22', '3', '2', 'Martin GBPC Steel String Backpacker Guitar w/Bag');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Tuy Little Martin là cây guitar kích thước nhỏ nhất của chúng tôi nhưng nó có âm sắc rất đỉnh, chất lượng và linh hoạt không thể chê. Model LX1 này có mặt top bằng gỗ nguyên tấm Sitka spruce, mặt lưng và hông bằng gỗ mahogany cán mỏng HPL ở áp lực cao. Lý tưởng để mang theo khi đi du lịch, cho người đang học chơi guitar hoặc cho các buổi cắm trại và buổi tiệc trong nhà. Model này có các bộ phận làm từ gỗ bền vững được chứng nhận.', '10670000', '20', '2023-01-10', '3', '2', 'Martin X Series LX1 Acoustic Guitars with Bag');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Từ năm 1958, Epiphone Texan đã trở thành cảm hứng cho nhiều thế hệ nhạc sĩ đẳng cấp thế giới như Paul McCartney, Peter Frampton và Noel Gallagher của Oasis. Giờ đây, Texan một lần nữa được sản xuất tại Hoa Kỳ và được chế tác thủ công tại Bozeman, Montana bởi những nghệ nhân bậc thầy của Gibson. Thân đàn hoàn toàn bằng gỗ solid, hệ thống X-bracing và scale dài 25.5” với chất âm đầy nội lực. Dây đàn Gibson™.', '72490000', '20', '2023-01-05', '4', '2', 'Epiphone USA Texan Acoustic-Electric Guitar, Vintage Sunburst');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Epiphone và Slash tự hào giới thiệu Slash Collection. Là một phần của bộ sưu tập Inspired by Gibson, đây là bộ sưu tập tôn vinh những model có ảnh hưởng mà Slash đã sử dụng trong suốt sự nghiệp của mình, truyền cảm hứng cho nhiều thế hệ người hâm mộ âm nhạc trên khắp thế giới. Hoàn hảo cho mọi sân khấu và người chơi ở mọi trình độ, Epiphone Slash J-45 được chế tác từ gỗ thịt với mặt lưng và hông bằng gỗ mahogany nguyên tấm, mặt top gỗ Sitka spruce tự nhiên với pickguard phong cách thập niên 50, bộ khóa Grover® Rotomatic®, xương đàn và lược đàn Graph Tech® TUSQ®, trong đó có thể kể đến những dấu ấn riêng của Slash như cần đàn kiểu C, độ cong cần 16” hiện đại hơn, phẳng hơn, preamp LR Baggs™ VTC và pickup dưới xương đàn mang đến chất âm êm dịu khi cắm dây. Chỉ có ở Slash Collection là biểu tượng “Skully” được vẽ ở mặt sau đầu đàn và chữ ký của Slash trên tấm phủ ti chỉnh cần. Hộp đàn hardshell được làm custom với logo “Skully” của Slash.', '24860000', '20', '2023-01-06', '4', '2', 'Epiphone Slash J-45 Standard Acoustic Guitar w/ Case, Vermillion Burst');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'PRO-1 đã tiến một bước dài vào thế giới ghita mang nét đặc trưng đầy dũng mãnh của PRO Collection. Epiphone là một trong những hãng sản xuất guitar lâu đời nhất và được đánh giá cao nhất thế giới, tạo điều kiện thuận lợi cho mọi người học và chơi ghita.', '3850000', '20', '2022-08-12', '4', '2', 'Epiphone PRO-1 Acoustic Guitar, Vintage Sunburst');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Epiphone là một trong những hãng sản xuất ghita lâu đời nhất và được đánh giá cao nhất thế giới, giúp mọi người tiếp cận và chơi ghita dễ dàng hơn. PRO-1 đã tiến một bước dài vào thế giới ghita mang nét đặc trưng đầy dũng mãnh của PRO Collection.', '3850000', '20', '2023-01-15', '4', '2', 'Epiphone PRO-1 Acoustic Guitar, Natural');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Không ai là không biết đến Tom Petty. Dù chơi solo hay chơi cùng Heartbreakers, ông luôn tạo nên những ca khúc được yêu thích nhất và trường tồn nhất trong kỷ nguyên nhạc rock. Mẫu SJ-200 Wildflower nguyên bản được chế tác dành riêng cho Tom trong kỷ nguyên Wildflowers vào thập niên 90 là một model độc nhất vô nhị. Giờ đây Gibson tự hào giới thiệu Tom Petty SJ-200 Wildflower - một model lấy cảm hứng từ cây guitar nguyên mẫu của Tom. Nổi bật với mọi hoạ tiết và đường nét của mẫu SJ-200 kinh điển, mặt top bằng gỗ Sitka spruce AAA, mặt lưng bằng gỗ quilted maple, mặt hông và cần đàn bằng gỗ flamed maple. Bộ khóa Grover® Imperial® vàng gold, pickup dưới saddle LR Baggs™ VTC, các điều khiển âm lượng và âm sắc được đặt ở lỗ thoát âm để dễ dàng điều chỉnh trên sân khấu, ngay khi bạn vừa lấy đàn ra khỏi case Wildflower custom đi kèm. Những điểm nhấn cá tính khác gồm logo Wildflower bằng chất liệu Mother of Pearl ở headstock, decal \"You Belong Among the Wildflowers” ở mặt lưng headstock và chữ ký của Tom Petty ở pickguard đã khiến cây guitar này trở nên đặc biệt hơn nữa. Chỉ 100 cây được chế tác thủ công bởi những nghệ nhân điêu luyện và thợ thủ công xuất sắc của Gibson Acoustic Custom Shop tại Bozeman, Montana.', '266860000', '20', '2022-09-11', '5', '2', 'Gibson Montana Custom Tom Petty SJ-200 Wildflower Signature Acoustic Guitar, Antique Natural');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Hơn một thập kỷ qua, danh thủ người Úc Orianthi Panagaris đã đốn gục trái tim người hâm mộ bằng lối chơi phá cách của mình, cô cũng hợp tác cùng những tên tuổi nổi tiếng như Michael Jackson, Alice Cooper, Carrie Underwood, Richie Sambora và nhiều nghệ sĩ lớn khác. Ngoài lối chơi nổi bật thì cây Gibson signature của Orianthi cũng rất được lòng giới mộ điệu. Với mặt top bằng gỗ Sitka spruce AAA trên thân đàn SJ-200, mặt lưng bằng gỗ flamed maple và cần đàn ES-345, đây chắc chắn là một model khác biệt so với mẫu SJ-200 tiêu chuẩn. Những nét chấm phá đậm cá tính khác của cô trên model này thể hiện qua mặt cần ebony với các hoạ tiết inlay hoa sen, biểu tượng Orianthi O bằng ngọc trai ở đầu đàn, bộ khóa Grover® Keystone, finish Cherry nitrocellulose lacquer và các pickup LR Baggs™ Orianthi Pickup System được chỉnh tiếng, các điều khiển để điều chỉnh bão hòa được gắn ở lỗ thoát âm.', '146740000', '20', '2022-03-25', '5', '2', 'Gibson Custom Modern Collection Orianthi SJ-200 Acoustic Guitar, Cherry');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'J-15 được lắp ráp thủ công từ tonewood tự nhiên, mặt đàn gỗ Sitka spruce, lưng và cạnh đàn gỗ walnut, và cần gỗ maple. Được chế tạo bởi các nghệ nhân bậc thầy và sử dụng cùng phương pháp với mọi Gibson Acoustic models, J-15 có khớp nối cần-thân chắc chắn kết dính bằng keo dán gỗ. Hoàn thiện với hệ thống LR Baggs Element pickup.', '49610000', '20', '2023-01-18', '5', '2', 'Gibson Montana 2019 J-15 Acoustic Guitar, Antique Natural');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Đối với acoustic gia công bằng tay mang chất lượng cao cấp và giá thành cũng rất xứng đáng, thật khó để ngược về thời gian của Gibson J-15 acoustic-electric guitar 2018. Cây dreadnought là một phần của gia đình J-45 đang trên đà phát triển, sở hữu mặt đàn gỗ thông sitka tự nhiên, lưng và eo đàn gỗ óc chó, kết hợp với cần đàn gỗ phong có mặt cần cũng bằng gỗ óc chó, mang lại vẻ đẹp duyên dáng đến từ Mỹ. Hệ thống LR Baggs Element thể hiện âm thanh kết nối tuyệt vời, giúp cho J-45 kiểu vai bo tròn luôn là hậu duệ xứng danh.', '55330000', '20', '2023-01-17', '5', '2', 'Gibson 2018 J-15 Acoustic Guitar w/Case, Walnut Burst');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Đây là nhạc cụ tổng hợp mẫu analog Nord Lead A1 mới, tổng hợp âm thanh tuyệt đẹp với giao diện mạnh mẽ nhưng lại vô cùng đơn giản. Tạp ra âm thanh nổi bật trong studio hay diễn live, Lead A1 lý tưởng cho mọi thể loại âm nhạc. Nhờ giao diện người dùng được sắp xếp tỉ mỉ, Lead A1 khuyến khích thử nghiệm, cho phép lập trình nhanh hơn nhiều và cuối cùng mang lại kết quả âm thanh hay đến lạ thường.', '41910000', '20', '2022-11-06', '6', '3', 'Nord Lead A1 Synthesizer');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Với các tính năng trình diễn mới, khả năng đồng bộ hóa và phân lớp tiên tiến, bộ lọc mới và hiệu ứng ngay trên mặt đàn, Nord Lead 4 là giấc mơ về nhạc cụ tổng hợp đã trở thành hiện thật.', '55330000', '20', '2022-02-07', '6', '3', 'Nord Lead 4 Synthesizer');

INSERT INTO `hudagon_music`.`product` (`delete_status`, `description`, `price`, `quantity`, `register_day`, `brand_id`, `category_id`, `name`) 
VALUES ('1', 'Nord Stage 3 là thế hệ thứ năm của series Stage rất thành công của hãng. Tiếp tục theo đuổi nguyện vọng của chính Nord là tạo ra nhạc cụ tối ưu cho nghệ sĩ biểu diễn. Dòng nhạc cụ chủ chốt mới và ưu tú này có ba model: Compact, HP 76 và HP88. Cả ba đều sở hữu công nghệ đoạt được giải thưởng mới nhất của Nord gồm Nord Lead A1 Synth Engine có sample playback, Nord C2D organ đình đám, Piano Section được nâng cấp và Hiệu ứng thực hành rộng rãi - tất cả đều có trong keyboard hiệu suất đặc biệt. Hai màn hình hiển thị OLED cực rõ hỗ trợ rõ nét trên sân khấu, chuyển tiếp liền mạch khi thay đổi chương trình / âm thanh, chức năng chia tách mở rộng với tính năng chuyển đổi tuỳ chọn và bổ sung Song List Mode mới giúp Nord Stage 3 trở nên nhạy hơn, linh hoạt hơn tạo điều kiện cho nghệ sỹ diễn live.', '112530000', '20', '2021-09-02', '6', '3', 'Nord Stage 3 HP76 Stage Keyboard');

-- Guitar -- 

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_pickups`, `hardware_finish`, `neck_curvature`, `neck_inlay`, `scale_length`, `product_id`) 
VALUES ('Quilted Maple Art Grain top, Poplar body', '1', 'Infinity R (H) (Neck & Bridge), Infinity RS (S) (Middle)', 'Chrome', '305mmR', 'White dot', '648mm/25.5\"\"', '8');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_string`, `hardware_finish`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `tuning_machine`, `product_id`) 
VALUES ('Sitka Spruce (Top), East Indian Rosewood (Back & Sides)', '1', 'Ply Hardshell', 'Abalone, Style 45 Snowflake', 'Tortoise Pattern', 'Martin® Authentic Acoustic® Lifespan® 2.0 strings, .012-.054 Gauges', 'Vàng gold', 'Abalone, Style 45 Snowflake', 'Ebony', '20', '25.4\"', '', '9');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_string`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('MahoganyEngelman Spruce (Top), East Indian Rosewood (Back & Sides) ', '1', '	Ply Hardshell with Embroidery', 'Modern Belly - Drop in Saddle ', 'Tortoise Pattern', 'Martin® Authentic Acoustic® Lifespan® 2.0 strings - Light', 'Mother of Pearl ', 'Ebony', '20', '25.5” ', '10');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_string`, `hardware_finish`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Sitka Spruce (Top), High-Pressure Laminated (Back & Sides)', '1', 'Soft Gig Bag', 'FSC® Certified Richlite®, Junior Style Belly - Drop in Saddle', 'Martin® Authentic Acoustic® Lifespan® 2.0', 'Chrome', 'Mother-of-Pearl Pattern', 'FSC® Certified Richlite®', '20', '23\"', '12');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bridge`, `guitar_pick_guards`, `guitar_pickups`, `guitar_string`, `neck_curvature`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Solid Mahogany (Back) Solid Spruce (Top)', '1', 'Indian rosewood', 'Authentic Celluloid Pickguard', 'LR Baggs™ (Under Saddle)', '0.12 - .016 Gauges', '12\"', 'Mother-of-Pearls Single Parallelogram', 'Mahogany', '20', '25.5” (647.7 mm)', '13');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_string`, `neck_curvature`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Solid Mahogany (Body, Back & Sides), Solid Sitka Spruce (Top)', '1', 'Hộp đàn hardshell được làm custom với logo “Skully” của Slash', 'Reverse Belly, Indian Laurel', 'Tortoise Shell, 50s J-45 Shape', '.012 .016 .024 .032 .042 .053 Gauges', '16\"', 'Mother of Pearl Dots', 'Indian Laurel', '20 Medium Jumbo', '24,75 / 628,65 mm', '14');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bridge`, `guitar_nut`, `guitar_pick_guards`, `guitar_string`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Gỗ săng đào qua chọn lọc', '1', 'Gỗ hồng', 'Graphtech NuBone', 'Đen, Scratchless', 'Epiphone Ultra-Light (9-47)', 'chấm tròn', 'Gỗ săng đào', '20; JumboPRO', '62,86 cm', '15');

INSERT INTO `hudagon_music`.`guitar` (`body_color`, `body_wood`, `delete_status`, `guitar_pick_guards`, `guitar_string`, `hardware_finish`, `neck_inlay`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Màu gỗ tự nhiên', 'Gỗ thông (Mặt đàn) / Gỗ săng đào (Thùng đàn)', '1', 'Đen; Scratchless', 'Epiphone Ultra-Light (9-47)', 'Chrome', 'Chấm tròn', '20', '62,86 cm', '16');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_pickups`, `guitar_string`, `hardware_finish`, `neck_curvature`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `product_id`) 
VALUES ('Quilted Maple (Body), AAA Sitka Spruce (Top)', '1', 'Custom Wildflower', 'Four bar SJ-200 Moustache; Rosewood', 'Black/White with ENgraved Tom Petty Signature', 'LR Baggs VTC (Under Saddle)', '012, .016, .024, .032, .042, .053', 'Vàng gold', '12\"', 'Mother of Pearl Graduated Crowns', 'Indian Rosewood, Bound', '20 Standard Small Crown', '25,5 / 647,7 mm', '17');

INSERT INTO `hudagon_music`.`guitar` (`body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_string`, `hardware_finish`, `neck_curvature`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`) 
VALUES ('AAA Flame Maple (Body), AAA Sitka Spruce (Top), AAA Flame Maple (Back), Maple (Side)', '1', 'Gibson Hardshell', 'Hai thanh SJ-200 Moustache; Ebony', 'SJ-200 với Lotus Flowers', '.012, .016, .024, .032, .042, .053 Gauges', 'Vàng gold', '12\"', 'Mother of Pearl Lotus', '2-piece Maple with Walnut Stringer', '20', '25.5\"');

INSERT INTO `hudagon_music`.`guitar` (`body_color`, `body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pickups`, `guitar_string`, `hardware_finish`, `neck_curvature`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `tuning_machine`, `product_id`) 
VALUES ('Antique Natural', 'Sitka Spruce (Mặt đàn), Walnut (Lưng đàn)', '1', 'Gibson Hardshell', 'Rectangular, closed slot, Walnut', 'LR Baggs™ Element', '0.053, 0.042, 0.032, 0.024, 0.016, 0.012', 'Nickel', '12\"', 'Mother-of-pearl dots', 'Richlite', '20', '24.75”', 'Mini Grover Rotomatic', '19');

INSERT INTO `hudagon_music`.`guitar` ( `body_color`, `body_wood`, `delete_status`, `guitar_bag`, `guitar_bridge`, `guitar_pick_guards`, `guitar_pickups`, `hardware_finish`, `neck_inlay`, `neck_material`, `number_of_frets`, `scale_length`, `tuning_machine`) 
VALUES ('Màu gỗ óc chó cháy', 'Gỗ thông Sitka (Mặt đàn), Gỗ óc chó (Lưng & Eo đàn), Gỗ phong (Cần)', '1', 'Màu đen', 'Gỗ óc chó', 'Hình mai rùa', 'LR Baggs Element', 'Nickel', 'Chấm tròn trắng', 'Gỗ óc chó', '20', '62,8cm', 'Mini Grover');

-- Piano -- 

INSERT INTO `hudagon_music`.`piano` (`connect_method`, `key_sensitivity`, `max_polyphony`, `number_of_keys`, `piano_accessories`, `piano_effect`, `piano_size`, `piano_weight`, `product_id`) 
VALUES ('Audio outputs x4; Headphone out; MIDI In/Out; USB; Control pedal; Sustain pedal', 'Bàn phím nhạy cảm với vận tốc', '26', '49', 'Hướng dẫn sử dụng, Dây nguồn với đầu nối IEC C14', 'Ensemble, Chorus, Phaser, Flanger, Ring Modulator, Drive, Delay, Reverb', '802 x 92 x 260mm (31,5 x 3,6 x 10,2\")', '4,85kg (10,7 lbs)', '21');

INSERT INTO `hudagon_music`.`piano` (`connect_method`, `delete_status`, `key_sensitivity`, `max_polyphony`, `number_of_keys`, `piano_accessories`, `piano_effect`, `piano_size`, `piano_sound`, `piano_tuning`, `piano_weight`) 
VALUES ('Control Pedal, Sustain Pedal, USB, MIDI In/Out, Line Out x4, Headphones', '1', 'Nhạy cảm với vận tốc', '20', '49', 'Hướng dẫn sử dụng, Dây nguồn với đầu nối IEC C14, Nord CD ROM với Nord Sound Manager', 'Phần FX với điều khiển Drive / Modulation liên tục. Crush, Drive, 2 hiệu ứng Talk khác nhau, Compressor và Comb Filter. Delay, Reverb', '864 x 94 x 272mm (34,0 x 3,7 x 10,7\")', 'Analog Voice', 'Tổng hợp trọng lực', '5,3kg (11,7 lbs)');

INSERT INTO `hudagon_music`.`piano` (`delete_status`, `number_of_keys`, `piano_accessories`, `piano_effect`, `piano_size`, `piano_weight`, `product_id`) 
VALUES ('1', '73', 'Hướng dẫn sử dụng, Bao chống bụi (HP76 & HP88), Sustain Pedal (HP76 & HP88), Power Cord, USB Cord, Nord Piano & Sample DVDs', 'Ring Modulator, Tremolo, Auto Pan, Wah-Wah, AutoWah 1, Autowah 2, Flanger, Vibe, 2 Phasers, 2 Choruses', '1287mm (50,7\"), 118mm (4,7\"), 334mm (13\")', '19kg (41,8 lb)', '23');

INSERT INTO `hudagon_music`.`piano` (`delete_status`, `number_of_keys`, `piano_accessories`, `piano_effect`, `piano_size`, `piano_weight`, `product_id`) 
VALUES ('1', '76', 'Hướng dẫn sử dụng, Bao chống bụi (HP76 & HP88), Sustain Pedal (HP76 & HP88), Power Cord, USB Cord, Nord Piano & Sample DVDs', 'Ring Modulator, Tremolo, Auto Pan, Wah-Wah, AutoWah 1, Autowah 2, Flanger, Vibe, 2 Phasers, 2 Choruses', '1122 mm (44\"), 127 mm (5\"), 347 mm (13,6\")', '12,5 kg (27,5 lb)', '24');

-- Img url product --

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FI01-GRX70QA-TBB_2FI01-GRX70QA-TBB_1587097833920_640x640.jpg?v=1609777649', '8');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FI01-GRX70QA-TBB_2FI01-GRX70QA-TBB_1587097833931_640x640.jpg?v=1609777653', '8');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FI01-GRX70QA-TBB_2FI01-GRX70QA-TBB_1587097833932_640x640.jpg?v=1609777658', '8');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764780_640x640.jpg?v=1654450772', '9');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764781_640x640.jpg?v=1654450777', '9');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764782_640x640.jpg?v=1654450780', '9');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764793_640x640.jpg?v=1654450783', '9');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764794_640x640.jpg?v=1654450787', '9');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10Y18OM42_2FM07-10Y18OM42_1654450764795_640x640.jpg?v=1654450791', '9');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10OMJMJOHNMAYER_2FM07-10OMJMJOHNMAYER_1619768478410_640x640.jpg?v=1619768486', '10');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10OMJMJOHNMAYER_2FM07-10OMJMJOHNMAYER_1619768478411_640x640.jpg?v=1619768489', '10');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10OMJMJOHNMAYER_2FM07-10OMJMJOHNMAYER_1619768478412_640x640.jpg?v=1619768493', '10');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10OMJMJOHNMAYER_2FM07-10OMJMJOHNMAYER_1619768478413_640x640.jpg?v=1619768496', '10');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-10OMJMJOHNMAYER_2FM07-10OMJMJOHNMAYER_1619768478414_640x640.jpg?v=1619768500', '10');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11GBPC_2FM07-11GBPC_1587373523010_640x640.jpg?v=1587373843', '11');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11GBPC_2FM07-11GBPC_1587373523011_640x640.jpg?v=1587373847', '11');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11GBPC_2FM07-11GBPC_1587373523022_640x640.jpg?v=1587373852', '11');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11GBPC_2FM07-11GBPC_1587373523023_640x640.jpg?v=1587373857', '11');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11LX1_2FM07-11LX1_1642585908070_640x640.jpg?v=1642585915', '12');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11LX1_2FM07-11LX1_1642585908071_640x640.jpg?v=1642585918', '12');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FM07-11LX1_2FM07-11LX1_1642585908072_640x640.jpg?v=1642585922', '12');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-OCRSETVS_2FE09-OCRSETVS_1605859830051_640x640.jpg?v=1657864549', '13');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-OCRSETVS_2FE09-OCRSETVS_1605859830052_640x640.jpg?v=1657864553', '13');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-OCRSETVS_2FE09-OCRSETVS_1605859830050_640x640.jpg?v=1657864557', '13');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353520_640x640.jpg?v=1650444175', '14');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353521_640x640.jpg?v=1650444177', '14');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353522_640x640.jpg?v=1650444182', '14');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353523_640x640.jpg?v=1650444186', '14');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353524_640x640.jpg?v=1650444188', '14');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EISLASHJ45VMNH3_2FE09-EISLASHJ45VMNH3_1627030353525_640x640.jpg?v=1650444191', '14');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EAPRVSCH1_2FE09-EAPRVSCH1_1604570670980_640x640.jpg?v=1604570680', '15');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EAPRVSCH1_2FE09-EAPRVSCH1_1604570670981_640x640.jpg?v=1604570685', '15');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FE09-EAPRVSCH1_2FE09-EAPRVSCH1_1604570670982_640x640.jpg?v=1604570690', '15');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/E09-EAPRNACH1_1527755382783_640x640.jpg?v=1535512990', '16');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBTPAN_2FG06-AMJBTPAN_1618820920190_640x640.jpg?v=1657869114', '17');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBTPAN_2FG06-AMJBTPAN_1618821845281_640x640.jpg?v=1657869118', '17');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBTPAN_2FG06-AMJBTPAN_1618820920191_640x640.jpg?v=1657869122', '17');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBTPAN_2FG06-AMJBTPAN_1618821845283_640x640.jpg?v=1657869125', '17');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBTPAN_2FG06-AMJBTPAN_1618820920192_640x640.jpg?v=1657869129', '17');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040060_640x640.jpg?v=1657869144', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040061_640x640.jpg?v=1657869147', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040062_640x640.jpg?v=1657869151', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040063_640x640.jpg?v=1657869154', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040064_640x640.jpg?v=1657869156', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-AMJBOR20CH_2FG06-AMJBOR20CH_1622617040065_640x640.jpg?v=1657869159', '18');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/G06-RS15ANN19_1546220500073_640x640.jpg?v=1580273521', '19');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/G06-RS15ANN19_1546220500223_640x640.jpg?v=1580273526', '19');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/G06-RS15ANN19_1546220500293_640x640.jpg?v=1580273530', '19');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/G06-RS15ANN19_1546220500337_640x640.jpg?v=1580273535', '19');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-RS15SBNH8_2FG06-RS15SBNH8_1573636880090_640x640.jpg?v=1574304042', '20');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-RS15SBNH8_2FG06-RS15SBNH8_1573636880091_640x640.jpg?v=1574304044', '20');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/products_2FG06-RS15SBNH8_2FG06-RS15SBNH8_1573636880092_640x640.jpg?v=1574304046', '20');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/N10-10691_001_640x640.jpg?v=1526713062', '21');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/N10-10821_1533698828110_640x640.jpg?v=1533699593', '23');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/N10-10821_1533698828199_640x640.jpg?v=1533699593', '23');

INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/N10-10811_1533698725146_640x640.jpg?v=1618984340', '24');
INSERT INTO `hudagon_music`.`img_url_product` (`delete_status`, `url`, `product_id`) VALUES ('1', 'https://cdn.shopify.com/s/files/1/0020/5111/2996/products/N10-10811_1533698725232_640x640.jpg?v=1618984344', '24');