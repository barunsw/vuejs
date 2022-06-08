<template>
  <div>
    <main class="mt-3">
        <div class="container">
            <h2 class="text-center">제품 사진 등록</h2>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품 ID</label>
                <div class="col-md-9">
                    {{productId}}
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품명</label>
                <div class="col-md-9">
                    {{productDetail.productName}}
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">썸네일이미지</label>
                <div class="col-md-9">
                    <input type="file" class="form-control" accept="image/png,image/jpeg">
                    <div class="alert alert-secondary" role="alert">
                        <ul>
                            <li>이미지 사이즈 : 350*350</li>
                            <li>파일 사이즈 : 1M 이하</li>
                            <li>파일 확장자 : png, jpg만 가능</li>
                        </ul>
                      </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품이미지</label>
                <div class="col-md-9">
                    <input type="file" class="form-control" accept="image/png,image/jpeg">
                    <div class="alert alert-secondary" role="alert">
                        <ul>
                            <li>최대 5개 가능</li>
                            <li>이미지 사이즈 : 700*700</li>
                            <li>파일 사이즈 : 1M 이하</li>
                            <li>파일 확장자 : png, jpg만 가능</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품설명이미지</label>
                <div class="col-md-9">
                    <input type="file" class="form-control" accept="image/png,image/jpeg">
                    <div class="alert alert-secondary" role="alert">
                        <ul>
                            <li>파일 사이즈 : 5M 이하</li>
                            <li>파일 확장자 : png, jpg만 가능</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-dark" @click="goToList()">취소하기</button>
                </div>
                <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-danger">저장하기</button>
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
            productImage: []
        }
    },
    computed: {
        user() {
            return this.$store.state.user;
        }
    },
    created() {
        this.productId = this.$route.query.product_id;
        this.getProductDetail();
        this.getProductImage();
    },
    mounted() {
        if (this.user.email == undefined) {
            alert('로그인을 해야 이용할 수 있습니다.')
            this.$router.push({path:'/'});
        }
    },
    methods: {
        goToList() {
            this.$router.push({path: '/sales'})
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
