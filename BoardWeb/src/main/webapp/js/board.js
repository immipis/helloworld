console.log('start');

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
//이벤트
document.querySelector('#addBtn').addEventListener('click',function(e){
	let reply = document.querySelector('#reply').value;
	if(!logId || !reply){
		alert("필수 입력값을 확인")
		return;
	}
	fetch('addReply.do?bno='+bno+'&replyer='+logId+'&reply='+reply)
		.then(result => result.json())
		.then(result => {
			console.log(result);//결과확인
			if (result.retCode == 'OK') {
				let html = `<li data-rno="${result.retVal.replyNo}">
							<span class="col-sm-2">${result.retVal.replyNo}</span>
							<span class="col-sm-5">${result.retVal.reply}</span> 
							<span class="col-sm-2">${result.retVal.replyer}</span> 
							<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${result.retVal.replyNo})">삭제</button></span>
						</li>`;
				let target = document.querySelector('div.reply ul.list');
				target.insertAdjacentHTML('afterbegin', html);
				
				document.querySelector('#reply').value='';
			}
			else {
				alert("추가 안됨")
			}		
		})
		.catch(err => console.log(err))
})



//댓글목록

fetch('replyList.do?bno=' + bno)
	.then(result => result.json())
	.then(result => {
		for (let reply of result) {
			let html = `<li data-rno="${reply.replyNo}">
						<span class="col-sm-2">${reply.replyNo}</span>
						<span class="col-sm-5">${reply.reply}</span> 
						<span class="col-sm-2">${reply.replyer}</span> 
						<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
					</li>`;
			let target = document.querySelector('div.reply ul.list');
			target.insertAdjacentHTML('afterbegin', html);
		}
	})
	.catch(err => console.log(err));
	

