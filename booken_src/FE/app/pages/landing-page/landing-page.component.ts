import { Component, OnInit } from "@angular/core";
import { ToastrService } from "ngx-toastr";
import { AuthorService } from "src/app/services/author.service";
import { BookService } from "src/app/services/book.service";
import { CategoryService } from "src/app/services/category.service";
import { OrderService } from "src/app/services/order.service";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.css"],
})
export class LandingPageComponent implements OnInit {

  /* Show */
  bookListHomeShow: any = [];
  priceRangeList: any = [];
  authorList: any = [];
  categoryList: any = [];

  /* Search info */
  name: string = "";
  categoryId: number = -1;
  authorId: number = -1;
  pageNumber: number = 0;
  priceRangeId: number = 0;
  pageSize: number = 6;
  sortOption: number = 0;
  sortDirection: boolean = true;

  /* Pagination information */
  totalPages: number = 0;
  currentPage: number = 0;

  constructor(
    private bookService: BookService,
    private authorService: AuthorService,
    private categoryService: CategoryService,
    private orderService: OrderService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.searchBook();
    this.getAllPriceRanges();
    this.getCategoryList();
    this.getAuthorList();
  }

  /* Order methods */
  addToCart(id: number) {
    this.orderService.addToCart(id).subscribe((data) => {
      this.toastr.success('Add to cart successfully!')
    });
  }

  /* Pagination methods */
  toPage(page: number) {
    this.pageNumber = page;
    this.searchBook();
  }

  previousPage() {
    this.pageNumber--;
    this.searchBook();
  }

  nextPage() {
    this.pageNumber++;
    this.searchBook();
  }

  /* Search and filter methods */
  searchBook() {
    const bookSearchInfo = {
      name: this.name,
      categoryId: this.categoryId,
      authorId: this.authorId,
      pageNumber: this.pageNumber,
      priceRangeId: this.priceRangeId,
      pageSize: this.pageSize,
      sortOption: this.sortOption,
      sortDirection: this.sortDirection,
    };

    this.bookService.searchBook(bookSearchInfo).subscribe((data) => {
      this.totalPages = data.totalPages;
      this.currentPage = data.pageable.pageNumber;

      this.bookListHomeShow = data.content;
    });
  }

  getAllPriceRanges() {
    this.bookService.getAllPriceRanges().subscribe((data) => {
      this.priceRangeList = data;
    });
  }

  getAuthorList() {
    this.authorService.getAuthorList().subscribe((data) => {
      this.authorList = data;
    });
  }

  getCategoryList() {
    this.categoryService.getCategoryList().subscribe((data) => {
      this.categoryList = data;
    });
  }

  changePrice(id: number) {
    this.priceRangeId = id;
    this.searchBook();
  }

  changeAuthor(id: number) {
    this.authorId = id;
    this.searchBook();
  }

  changeCategory(id: number) {
    this.categoryId = id;
    this.searchBook();
  }

  resetSearchInfo() {
    this.name = "";
    this.categoryId = -1;
    this.authorId = -1;
    this.pageNumber = 0;
    this.priceRangeId = 0;
    this.pageSize = 6;
    this.sortOption = 0;
    this.sortDirection = false;

    this.searchBook();
  }
}
