package com.wpaul15.cookbook.shared

class Greeting {

	fun greeting(): String {
		return "Running ${Platform().platform}!"
	}
}
