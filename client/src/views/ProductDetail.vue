<template>
  <div>
    <main class="mt-3">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-ride="true">
                        <div class="carousel-indicators">
                          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                          <div :class="`carousel-item ${i==0?'active':''}`" :key=i v-for="(productImage, i) in productImage">
                            <img :src="productImage.imagePath" class="d-block w-100" alt="...">
                          </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Next</span>
                        </button>
                      </div>
                </div>
                <div class="col-md-7">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">{{productDetail.productName}}</h5>
                            <h5 class="card-title pt-3 pb-3 border-top">{{$currencyFormat(productDetail.productPrice)}}원</h5>
                            <p class="card-text border-top pt-3">
                                <span class="badge bg-dark me-1">{{productDetail.category1}}</span>
                                <span class="badge bg-dark me-1">{{productDetail.category2}}</span>
                                <span class="badge bg-dark me-1">{{productDetail.category3}}</span>
                            </p>
                            <p class="card-text pb-3">
                                배송비 {{$currencyFormat(productDetail.deliveryPrice)}}원 | 도서산관(제주도) 배송비 추가 {{$currencyFormat(productDetail.addDeliveryPrice)}}원 | 택배배송 | {{productDetail.outboundDays}}일 이내 출고
                            </p>
                            <div class="card-text border-top pt-3 pb-3">
                                <div class="row">
                                    <div class="col-auto">
                                        <label class="col-form-label">구매수량</label>
                                    </div>
                                    <div class="col-auto">
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" style="cursor:pointer;" @click="calculatePrice(-1)">-</span>
                                            <input type="text" class="form-control" style="width:50px;" v-model="total">
                                            <span class="input-group-text" style="cursor:pointer;" @click="calculatePrice(1)">+</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row pt-3 pb-3 border-top">
                                <div class="col-auto col-6">
                                    <h3>총 상품 금액</h3>
                                </div>
                                <div class="col-auto col-6" style="text-align: right;">
                                    <h3>{{$currencyFormat(totalPrice)}}원</h3>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="col-6 d-grid p-1">
                                    <button type="button" class="btn btn-lg btn-dark">장바구니 담기</button>
                                </div>
                                <div class="col-6 d-grid p-1">
                                    <button type="button" class="btn btn-lg btn-danger">주문하기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <img :src="productDetail.imagePath" 
                        class="img-fluid"/>
                </div>
            </div>
        </div>
    </main>
  </div>
</template>

<script>
export default {
  data() {
    return {
        productId: 0,
        productDetail: {},
        productImage: [],
        total: 1,
        totalPrice: 0
    }
  },
  created() {
    this.productId = this.$route.query.product_id;
    this.getProductDetail();
    this.getProductImage();
  },
  methods: {
    calculatePrice(cnt) {
        let total = this.total + cnt;

        if (total < 1) total = 1;

        this.total = total;

        this.totalPrice = this.total * this.productDetail.productPrice;
    },
    async getProductDetail() {
      let result = await this.$api("/api/product/detail/" + this.productId, "GET", {});
      if (result != null && result.data.length > 0) {
        this.productDetail = result.data[0];
        this.totalPrice = this.total * this.productDetail.productPrice;
      }
    },
    async getProductImage() {
      let result = await this.$api("/api/product/image/" + this.productId, "GET", {});
      this.productImage = result.data;
    }
  }
}
</script>