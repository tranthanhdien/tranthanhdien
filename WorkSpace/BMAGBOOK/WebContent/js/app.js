$(function () {
    // Task 1: Make post form on top width overlay
    var $overlay = $('<div id = "overlay"></div>');
    var $post_form = $('#post-form');
    var $post_form_editor = $('#post-form-editor');
    var $post_form_close_button = $('#post-form-close-button');

    // Only use this as improved version
    var removeOnTop = function () {
        $overlay.hide();
        $post_form_close_button.hide();
        // force lose focus
        $post_form_editor.blur();
        $post_form.removeClass('on-top');
    };

    $post_form_editor.focus(function () {
        $overlay.toggle();
        $('body').append($overlay);

        $post_form.addClass('on-top');
        $post_form_close_button.show();

        /* Use these as first version
        $overlay.click(function () {
            $overlay.hide();
            $post_form_close_button.hide();
        });

        $post_form_close_button.click(function () {
            $overlay.hide();
            $(this).hide();
        }); */

        // Only use this as improved version
        $('#post-form-close-button, #overlay').on('click', removeOnTop);

        // ALso hide overlay when user scroll the window
        $(window).scroll(removeOnTop);
    });
    // End of Task 1

    // Task 2: create place holder text
    var $editable = $('[contenteditable]');
    $editable.html("<p class='place-holder-text'>What's on your mind?</p>");
    $editable.focus(function () {
        $(this).children('p').remove();
    });

    $editable.blur(function () {
        var content = $(this).html();
        if (content.length === 0) {
            $(this).html("<p class='place-holder-text'>What's on your mind?</p>");
        }
    });
    // End of task 2

    // Task 3: Basic efffects - confirm diaglog
    var $currentFriend;
    var $dialogConfirm = $('#dialog-confirm');
    $('.ignore-friend').click(function (e) {
        e.preventDefault();
        $currentFriend = $(this);
        // version 1
        //        $(this).parent('.friend-item').hide(200);
        // version 2
        //        $(this).parent('.friend-item').slideUp();
        // version 3
        //        $(this).parent('.friend-item').slideUp('fast');
        // Version 4
        //        $(this).parent('.friend-item').fadeOut('slow');

        $overlay.toggle();
        $('body').append($overlay);
        $("body").css("overflow", "hidden"); // prevent scrolling
        $dialogConfirm.show();
    });
    $('#dc-btn-yes').click(function (e) {
        e.preventDefault();
        $dialogConfirm.hide();
        $overlay.hide();
        $("body").css("overflow", "visible"); // allow scrolling again
        $currentFriend.parent('.friend-item').fadeOut(500);
    });

    $('#dc-btn-close, #dc-btn-no').on('click', function (e) {
        e.preventDefault();
        $dialogConfirm.hide();
        $overlay.hide();
        $("body").css("overflow", "visible"); // allow scrolling again
    });
    // End of task 3

    // Task 4: Show Friend Details popup
    // Step 4.1: declare variable (Need to remove :after/:before and replaced with back/front-triangle)
    var $friendDetailPopup = $('#friend-detail-popup');
    var currentTop;
    var $backTriangle = $('#back-triange');
    var $backTriangleInitPos = 14;
    var $frontTriangle = $('#front-triange');
    var $frontTriangleInitPos = 15;
    var limit = 100;
    $('#online-list li').hover(function () {
        // Step 4.5: need to minus the limit to make sure the popup will not display for the last item at the bottom
        if ($(this).position().top >= $(window).height() - limit) {
            $friendDetailPopup.hide();
            return;
        }

        // Re-position of the popup so that it is not covered when reaching the bottom
        var popupTop = $(this).position().top; // need to get the top of the current hover item
        // calculate the bottom of the popup
        // We need the 'limit' to make sure we will not reach to close to the window's bottom
        var popupBottom = $friendDetailPopup.height() + popupTop + limit;

        // Step 4.4: if the popup reaches the bottom of the window, move the triangle at delta size
        if (popupBottom >= $(window).height()) {
            var delta = Math.round($friendDetailPopup.height() / 2);
            currentTop = $(this).position().top - delta;
            $backTriangle.css({
                top: ($backTriangleInitPos + delta) + 'px'
            });
            $frontTriangle.css({
                top: ($frontTriangleInitPos + delta) + 'px'
            });
        } else { // Step 4.2: Show the popup
            // Need to use position() to get the pos of the current element relative to the parent (#online-list)
            //            currentTop = $(this).position().top + 5; // 5 to minus from the top
            currentTop = popupTop + 5;
            $backTriangle.css({
                top: $backTriangleInitPos + 'px'
            });
            $frontTriangle.css({
                top: $frontTriangleInitPos + 'px'
            });
        }

        $friendDetailPopup.css({
            top: currentTop
        });
        $friendDetailPopup.show(200);

    });

    // Step 4.3: hide the popup when mouse leaves
    $('#online-list ul, #friend-detail-popup').on('mouseleave', function () {
        setTimeout(function () {
            if (!$friendDetailPopup.is(':hover')) { // Check if the popup is NOT hover
                $friendDetailPopup.hide();
            }
        }, 1000);
    });
    // End of task 4

    // Task 5: Chat box
    var $chatEditor = $('#chat-box-editor');
    var initEditorHeight = $chatEditor.outerHeight();
    var editorHeight = initEditorHeight;
    var $chatContent = $('#chat-box-content');
    var initChatContentHeight = $('#chat-box-content').outerHeight();
    var $chatContentWrapper = $('#chat-box-content-wrapper');
    $chatEditor.keyup(function () {
        if ($chatEditor.html().length === 0) {
            $chatContent.css('height', initChatContentHeight + 'px'); // reset the size to original
            editorHeight = initEditorHeight;
        }
        var currentHeight = $chatEditor.outerHeight();
        if (currentHeight > editorHeight) {
            $chatContent.css('height', ($chatContentWrapper.outerHeight() - currentHeight) + 'px');
            editorHeight = currentHeight;
        }
    });

    $chatEditor.keydown(function (e) {
        // trap the return key being pressed
        if (e.keyCode === 13) {
            $chatContent.prepend('<div class="chat-item-friend-wrapper"><div class="chat-item-friend">' + $chatEditor.html() + '</div></div>');
            $chatContent.prepend('<div class="chat-item-me-wrapper"><div class="chat-item-me">' + $chatEditor.html() + '</div></div>');
            $chatEditor.html("");
            $chatContent.css('height', initChatContentHeight + 'px'); // reset the size to original
            editorHeight = initEditorHeight;
            return false; // prevent the defaul behavior of the enter key, which prevents the new line added
        }
    });

    $('#close-chat-box-button').on('click', function () {
        $('#chat-box').hide();
    });

    $('#show-chat-box-button').on('click', function (e) {
        e.preventDefault();
        $('#chat-box').toggle();
    });

    // End of task 5

    // Task 6: Validate inputs (Register page)
    var $regInput = $('.reg-input input, .reg-input select');
    var $errorIcon = $('.reg-input i');
    var $errorPopup = $('.error-popup');
    $regInput.on('focusout', function () {
        var $inputWrapper = $(this).parent();
        if (!$inputWrapper.children('i').hasClass('error-icon')) {
            $inputWrapper.addClass('error-focus');
            $inputWrapper.children('i').addClass('error-icon');
        }
    });
    $regInput.on('focus', function () {
        $errorPopup.hide(); // hide other popup
        var $inputWrapper = $(this).parent();
        if ($inputWrapper.children('i').hasClass('error-icon')) {
            $inputWrapper.children('i').removeClass('error-icon');
            $inputWrapper.removeClass('error-focus');

            if ($inputWrapper.attr('id') === 'last-name') {
                $inputWrapper.children('span.error-popup').addClass('error-popup-bottom').show();
            } else {
                // only show the current focus
                $inputWrapper.children('span.error-popup').addClass('error-popup-right').show();
            }
        }
    });
});
