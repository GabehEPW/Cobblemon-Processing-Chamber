package com.nbp.processing_chamber

import org.slf4j.LoggerFactory

object ProcessingChamber {
    const val MOD_ID = "processing_chamber"

    val logger = LoggerFactory.getLogger("ProcessingChamber")

    fun init() {
        logger.info("Processing Chamber loaded!")
    }
}
