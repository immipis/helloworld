console.log('start');

function makeRow(reply = {}) {
	let html = `<li data-rno="${reply.replyNo}">
							<span class="col-sm-2">${reply.replyNo}</span>
							<span class="col-sm-5">${reply.reply}</span> 
							<span class="col-sm-2">${reply.replyer}</span> 
							<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
						</li>`;
	let target = document.querySelector('div.reply ul.list');
	target.insertAdjacentHTML('beforeend', html);
}




//댓글 -> 삭제 -> retCode(OK,Fail)
function deleteReply(rno = 1) {
	fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert("삭제가 됨")
				document.querySelector('li[data-rno="' + rno + '"]').remove();
			}
			else {
				alert("삭제가 안됨")
			}
		})
		.catch(err => console.log(err))
}

// 댓글목록 5번씩 출력.
function showReplyList() {

	fetch('replyList.do?bno=' + bno + '&page=' + page)
		.then(result => result.json())
		.then(result => {
			document.querySelector('ul.list').innerHTML = '';
			for (let reply of result) {
				makeRow(reply)//댓글정보 <li/> 기능생성
			}
			//페이지 생성
			createPageList();
		})
		.catch(err => console.log(err));
}
let page = 1;

//글번호를 전달하면 댓글 건수 반환 => ㅠㅔ이지 계산 함수
function createPageList() {
	fetch('getCount.do?bno=' + bno)
		.then(result => result.json())
		.then(result => {
			let totalCnt = result.replyCount; // 댓글 전채 건수
			//이전, 이후 페이지 여부 , 첫번째 페이지~ 마지막 페이지
			let prev, next; //이전 이후 페이지
			let startPage, endPage, realEnd;

			endPage = Math.ceil(page / 10) * 10// 현재 페이지를 기준으로 마지막 페이지 계산
			startPage = endPage - 9;
			if (startPage > 1) {
				prev = true;
			}
			realEnd = Math.ceil(totalCnt / 5);

			if (endPage > realEnd) { //현재 13이라면 endpage = 20 
				endPage = realEnd
			}

			if (endPage < realEnd) { //현재 13이라면 endpage = 20 
				next = true;
			}


			//목록 작성
			let pagination = document.querySelector('ul.pagination')

			pagination.innerHTML = ''
			if (prev) {
				let html = `<li class="page-item" data-page="${startPage - 1}">
							<a class="page-link" href="#"aria-label="Previous"> 
							 <span aria-hidden="true">&laquo;</span></a></li>`
				pagination.insertAdjacentHTML('beforeend', html);
			}
			for (let p = startPage; p <= endPage; p++) {
				console.log(page)
				if (page == p) {
					let html = `<li class="page-item active" data-page=${p}>
								<a class="page-link" href="#">${p}</a></li>`
					pagination.insertAdjacentHTML('beforeend', html);
				}
				else {
					let html = `<li class="page-item" data-page=${p}>
												<a class="page-link" href="#">${p}</a></li>`
					pagination.insertAdjacentHTML('beforeend', html);
				}


			}
			if (next) {
				let html = `<li class="page-item" data-page="${endPage + 1}"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>`
				pagination.insertAdjacentHTML('beforeend', html);
			}

			//페이징 a태그의 출력
			document.querySelectorAll('ul.pagination a').forEach(item => {
				item.addEventListener('click', function(e) {
					e.preventDefault();//기본기능 차단
					//목록출력
					page = item.parentElement.getAttribute(`data-page`);
					showReplyList();
				})
			})
		})
		.catch(err => console.log(err));
} //end of createPageList


//이벤트
document.querySelector('#addBtn').addEventListener('click', function(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert("필수 입력값을 확인")
		return;
	}
	fetch('addReply.do?bno=' + bno + '&replyer=' + logId + '&reply=' + reply)
		.then(result => result.json())
		.then(result => {
			console.log(result);//결과확인
			let reply = result.retVal;
			if (result.retCode == 'OK') {
				makeRow(reply)
				document.querySelector('#reply').value = '';
			}
			else {
				alert("추가 안됨")
			}
		})
		.catch(err => console.log(err))
})


//댓글목록
showReplyList()

