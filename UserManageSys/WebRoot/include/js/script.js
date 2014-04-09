
(function($) { 
	// 文档准备好后，执行初始化函数
	$(document).ready(init);
	
	// 初始化函数
	function init() {
		hideLabel(); 							// 支持脚本时隐藏label元素
		addRequiredStar(); 						// 向必填input添加*
		altPlaceholder('input:not(:checkbox)');	// 替换HTML5 placeholder 
		IE_PIE('#reg, #add_count, #reg_new'); 	// 使用IE性能提升库
	};
	
	function hideLabel() {
		$('label', '#reg').not('[for=accept_terms]').addClass('blind');
	};
	
	function addRequiredStar() {
		var target = $('[required]', '#reg');
		$('<span/>', {
			text: '*',
			css: {
				'color': '#ff4248',
				'font': 'bold 12px Verdana',
				'vertical-align': 'middle',
				'margin-left': '5px'
			}
		}).insertAfter(target);
	};
	
	function altPlaceholder(target) {
		if(Modernizr.input.required) return;
		$(target).each(function() {
			var $this = $(this),
				input_holder = $this.attr('placeholder');
				$this
				.val(input_holder)
				.bind('focus', function() {
					if($this.val() !== '') $this.val('');
				})
				.bind('blur', function() {
					if($this.val() === '') $this.val(input_holder);
				});
		});
	};
	
	function IE_PIE(target) {
		if($.browser.msie && $.browser.version < 10) {
			if($.browser.version < 9) $.getScript('include/js/libs/IE9.min.js');
			$.getScript('include/js/libs/PIE.min.js', function() {
				$(target).each(function() { PIE.attach(this); });
			});
		};
	};
	
})(jQuery);